
public class Assignment4 
{
	public static void main(String args[])
	{
		int[] list = {5, 6, 4, 23, 7};
		list=mergeSort(list);
		for(int i=0; i<list.length; i++)
		{
			System.out.println(list[i]);
		}
	}
	public static int[] mergeSort(int [] list) 
	{
        if (list.length <= 1) 
        {
            return list;
        }
        
        int[] firstHalf = new int[list.length / 2];
        int[] secondHalf = new int[list.length - firstHalf.length];
        System.arraycopy(list, 0, firstHalf, 0, firstHalf.length);
        System.arraycopy(list, firstHalf.length, secondHalf, 0, secondHalf.length);
        
        mergeSort(firstHalf);
        mergeSort(secondHalf);
        
        merge(firstHalf, secondHalf, list);
        return list;
    }
    
    private static void merge(int[] a, int[] b, int [] result) 
    {
        int aIndex = 0;
     
        int bIndex = 0;
        
        int current = 0;

        while (aIndex < a.length && bIndex < b.length) {
            if (a[aIndex] < b[bIndex]) {
                result[current] = a[aIndex];
                aIndex++;
            } 
            else 
            {
            	result[current] = b[bIndex];
            	bIndex++;
            }
            current++;
        }
        
        System.arraycopy(a, aIndex, result, current, a.length - aIndex);
        System.arraycopy(b, bIndex, result, current, b.length - bIndex);
    }
    

}
