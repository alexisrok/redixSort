package meli.ejerc;

public class RadixSortEjerc
{

	public static void countingSort(int array[], int size, int place) {
		int[] output = new int[size + 1];

		int max = array[0];

		for (int i = 1; i < size; i++) {
			if (array[i] > max)
				max = array[i];
		}

		int[] count = new int[max + 1];

		for (int i = 0; i < max; ++i)
			count[i] = 0;

		for (int i = 0; i < size; i++)
			count[(array[i] / place) % 10]++;

		for (int i = 1; i < 10; i++)
			count[i] += count[i - 1];

		for (int i = size - 1; i >= 0; i--) {
			output[count[(array[i] / place) % 10] - 1] = array[i];
			count[(array[i] / place) % 10]--;
		}

		for (int i = 0; i < size; i++)
			array[i] = output[i];
	}

	public static int getMax(int array[], int n) {
		int max = array[0];
		for (int i = 1; i < n; i++)
			if (array[i] > max)
				max = array[i];
		return max;
	}

	public static void radixSort(int array[]) {
		int max = getMax(array, array.length);

		for (int place = 1; max / place > 0; place *= 10)
			countingSort(array, array.length, place);
	}

	public static void main(String[] args)
	{
		int arr[]={16223,898,13,906,235,23,9,1532,6388,2511,8};
		radixSort(arr);
		
		for(int i=0; i<arr.length;i++)
		{
			System.out.print(arr[i]+(i<arr.length-1?",":""));
		}
	}
}
