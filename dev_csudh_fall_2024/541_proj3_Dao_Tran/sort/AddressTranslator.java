import java.io.*;
import java.util.Scanner;
import java.util.Map;
import java.util.HashMap;
import java.util.LinkedHashMap;

public class AddressTranslator
{

	private static final int MAX_PAGE_FRAMES = 128; 
	public static void main(String[] args) throws java.io.IOException {

		Integer SIZE = 256;

		String inputFileName = "-1";
		File inputFile;
		File fileName;
		RandomAccessFile disk = null;
		byte val;

		HashMap<Integer, Integer> pageTable = new LinkedHashMap<>(128, 0.75f, false){
			//Overridding removeEldestEntry for FIFO implementation
			protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
				System.out.printf("Page Fault! Removing entry: " + eldest.getKey() + " due to page fault: " + eldest.getValue());
				return this.size() >= MAX_PAGE_FRAMES; 
			}
		};
		int pageFault = 0;
		int lines = 0;

		// gets the input file name
		if (args.length > 0) {
			inputFileName = args[0];
		} else {
			System.out.println("No input file provided as an argument.");
			System.exit(1);
		}

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

				// convert the virtual address to the physical address
				int virtualPage = virtualAddress / SIZE;
				int offset = virtualAddress % SIZE;

				// look for virtualPage in hashmap 
				// if not, add to hashmap w/ the corresponding pageFault
				if (pageTable.get(virtualPage) == null) {
					pageTable.put(virtualPage, pageFault);
					pageFault++;
				}
				// take the physicalFrame to calculate for physicalAddress
				int physicalFrame = pageTable.get(virtualPage);
				int physicalAddress = physicalFrame * SIZE + offset;

				// TLB ???????

				// get value
				disk.seek(virtualAddress);
				int value = (byte)disk.readUnsignedByte();

				// print out the value
				System.out.printf("%-16s %-10d %-17s %-10d %-7s %-5d%n", "Virtual Address: ", virtualAddress, "Physical Address: ", physicalAddress, "Value: ", value);
			}

			//	Print Stats
			System.out.println();
			System.out.println("STATISTICS");
			System.out.printf("%-26s %-10d%n", "Number of addresses given: ", lines);
			System.out.printf("%-22s %-10d%n", "Number of page faults: ", pageFault);
			float pageFaultRate = ((float)pageFault/(float)lines) * 100;
			System.out.printf("%-16s %.2f%%%n", "Page fault rate: ", pageFaultRate);
			System.out.println();

			//	print pageTable
			System.out.println("PAGE TABLE");
			for (Map.Entry<Integer, Integer> entry : pageTable.entrySet()) {
				System.out.printf("%-16s %-7d %-14s %-5d%n", "Physical Frame: ", entry.getValue(), "Virtual Page: ", entry.getKey());
			}

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