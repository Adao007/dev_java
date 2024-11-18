/*
	Anthony Dao
	Justine Tran
	CSC-541-01
	Fall 2024
	Project #3
	Extra Credit Part 2
*/

import java.io.*;
import java.util.Scanner;
import java.util.Map;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Arrays;
import java.util.Queue;
import java.util.LinkedList; 							

public class AddressTranslator
{

	public static void main(String[] args) throws java.io.IOException {

		Integer SIZE = 256;
		Integer TLB_SIZE = 16;	
		Integer MAX_PAGE_FRAMES = 128; 					

		String inputFileName = "-1";
		File inputFile;
		File fileName;
		RandomAccessFile disk = null;
		byte val;
		int lines = 0;
		// HashMap<Integer, Integer> pageTable = new LinkedHashMap<>();
		int pageFault = 0;
		boolean pf_algo = false; // variable for FIFO(false) or LRU(true)
		String TLB_algo = "-1";							
		int TLB_hits = 0;								
		int[] TLB_counter = new int[16];				
		int[] TLB_virtual = new int[16];			
		int[] TLB_physical = new int[16];			
		Arrays.fill(TLB_counter, -1);			
		Arrays.fill(TLB_virtual, -1);					
		Arrays.fill(TLB_physical, -1);	

		// Queue for tracking Physical Frame 
		Queue<Integer> Frames = new LinkedList<>();
		for(int i = 0; i < MAX_PAGE_FRAMES; i++) {
			Frames.add(i); 
		}				

		// gets the input file name
		if (args.length == 2) {	
			inputFileName = args[0];
			TLB_algo = args[1];	
			// Sets algorithm: LRU - Access Order: True otherwise it will have default (false)
			if(TLB_algo.equals("LRU")) {
				pf_algo = true; 
				System.out.println("LRU REACHED");
			}
		} else {
			System.out.println("Arguments: <inputFile.txt> <FIFO/LRU>");
			System.exit(1);
		}

		HashMap<Integer, Integer> pageTable = new LinkedHashMap<>(MAX_PAGE_FRAMES, 0.75f, pf_algo){
			@Override //Override removeEldestEntry for FIFO implementation
			protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
				if(this.size() >= MAX_PAGE_FRAMES) {
					Frames.add(eldest.getValue());
					return true; // Removed eldest entry 
				}
				return false; // No removal was needed 
			}
		};

		try {
			// opening InputFile.txt
			inputFile = new File(inputFileName);
			Scanner scanner = new Scanner(inputFile);

			// Opening BACKING_STORE.bin & sets pointer to beginning of file
			fileName = new File("BACKING_STORE.bin");
			disk = new RandomAccessFile(fileName, "r");
			disk.seek(0);

			// read in virtual addresses from InputFile.txt one-by-one
			while (scanner.hasNextLine()) { 
				lines++;
				int virtualAddress = scanner.nextInt();
				String newlineConsumer = scanner.nextLine();

				// get the virtualPage number & offset from the virtualAddress
				int virtualPage = virtualAddress / SIZE;
				int offset = virtualAddress % SIZE;
				int physicalFrame = -1;						

				// check TLB
				int TLB_found = -1;
				for (int i = 0; i < TLB_SIZE; i++) {
					if (TLB_virtual[i] == virtualPage) {
						TLB_found = i;
						break;
					}
				}

				// if TLB hit, get the page/frame & increment TLB_hits
				if (TLB_found != -1) {
					physicalFrame = TLB_physical[TLB_found];
					System.out.println("	TLB hit");
					TLB_hits++;
					// if LRU: update the counter
					if (TLB_algo.equals("LRU")) {
						TLB_counter[TLB_found] = lines;
						System.out.println("	LRU updated");
					}
				}
				else {
				// if miss, look for virtualPage in hashmap pageTable
					// if not found, add to pageTable hashmap w/ the corresponding pageFault
					// look for virtualPage in hashmap with queue implementation
					if (!pageTable.containsKey(virtualPage)) {
						if (Frames.isEmpty()) {
							pageTable.put(virtualPage, -1);
						}
						physicalFrame = Frames.poll();
						pageTable.put(virtualPage, physicalFrame);
						pageFault++;
				}

					// take the physicalFrame to calculate for physicalAddress
					physicalFrame = pageTable.get(virtualPage);

					// put in the TLB
					// check for empty spaces
					int TLB_empty = -1;
					for (int i = 0; i < TLB_SIZE; i++) {
						if (TLB_counter[i] == -1) {
							TLB_empty = i;
							break;
						}
					}

					// if empty, put in next spot
					if (TLB_empty != -1) {
						TLB_counter[TLB_empty] = lines;
						TLB_virtual[TLB_empty] = virtualPage;
						TLB_physical[TLB_empty] = physicalFrame;
					} 
					// if full, take lowest counter & replace (FIFO & LRU)
					else {
						int TLB_min = 1000000;
						int TLB_index = -1;
						for (int i = 0; i < TLB_SIZE; i++) {
							if (TLB_counter[i] < TLB_min) {
								TLB_min = TLB_counter[i];
								TLB_index = i;
							}
						}
						TLB_counter[TLB_index] = lines;
						TLB_virtual[TLB_index] = virtualPage;
						TLB_physical[TLB_index] = physicalFrame;
					}
				}

				int physicalAddress = physicalFrame * SIZE + offset;

				// get value
				disk.seek(virtualAddress);
				int value = (byte)disk.readUnsignedByte();

				// print out the value
				System.out.printf("%-16s %-10d %-17s %-10d %-7s %-5d%n", "Virtual Address: ", virtualAddress, "Physical Address: ", physicalAddress, "Value: ", value);
			}

			//	print pageTable
			System.out.println();
			System.out.println("PAGE TABLE");
			for (Map.Entry<Integer, Integer> entry : pageTable.entrySet()) {
				System.out.printf("%-16s %-7d %-14s %-5d%n", "Physical Frame: ", entry.getValue(), "Virtual Page: ", entry.getKey());
			}

			// print TLB 
			System.out.println();
			System.out.println("Final TLB");
			for (int i = 0; i < TLB_SIZE; i++) {
				System.out.printf("%-11s %-10d %-10s %-10d %-12s %-10d%n", "counter: ", TLB_counter[i], "Virtual: ", TLB_virtual[i], "Physical: ", TLB_physical[i]);
			}

			//	Print Stats
			System.out.println();
			System.out.println("STATISTICS");
			System.out.printf("%-26s %-10d%n", "Number of addresses given: ", lines);
			System.out.printf("%-22s %-10d%n", "Number of page faults: ", pageFault);
			float pageFaultRate = ((float)pageFault/(float)lines) * 100;
			System.out.printf("%-16s %.2f%%%n", "Page fault rate: ", pageFaultRate);
			System.out.printf("%-19s %-10d%n", "Number of TLB hits: ", TLB_hits);
			float TLB_hitsRate = ((float)TLB_hits/(float)lines) * 100;
			System.out.printf("%-13s %.2f%%%n", "TLB hit rate: ", TLB_hitsRate);
			System.out.println();
		}
		catch (FileNotFoundException e) {
			System.err.println ("Unable to open input file");
        	System.exit(1);
		}
		catch (IOException e) {
			System.err.println ("Unable to start the disk");
            System.exit(1);
		}
		finally {
			disk.close();
		}
	}
}