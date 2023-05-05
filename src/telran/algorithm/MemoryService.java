package telran.algorithm;

public class MemoryService {
	public static int getMaxAvailableSize() {
		int rightMemory = Integer.MAX_VALUE;
		int middleMemory = -1;
		int leftMemory = 0;
		while (leftMemory <= rightMemory) {
			middleMemory = rightMemory / 2 - leftMemory / 2 + leftMemory;
			try {
				
				byte[] array = new byte[middleMemory];
				leftMemory = middleMemory + 1;
				
			} catch(OutOfMemoryError e) {
				rightMemory = middleMemory - 1;
				
			}
			
		}
		return rightMemory;
		
	}
	


}
