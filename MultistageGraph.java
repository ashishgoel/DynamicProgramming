/******************************************************************************
Multistage Graph Theory: https://www.youtube.com/watch?v=9iE9Mj4m8jk
(Program written by Self)

       (1)
    3 /   \ 4
     /     \
 (0)       (3)
    \     / 6
   2 \   /
      (2)
      
Output:
Hello World
node = 0 --> cost = 7 dest = 1
node = 1 --> cost = 4 dest = 3
node = 2 --> cost = 6 dest = 3
node = 3 --> cost = 0 dest = 3
Finding shortest path...
0-->1-->3
*******************************************************************************/

public class MultistageGraph
{
	public static void main(String[] args) {
	    System.out.println("Hello World");
	    int n = 4;
		
	    Integer[][] arr= {
		    { null, 3,       2, null },
		    { null, null, null,    4 },
		    { null, null, null,    6 },
		    { null, null, null, null }
	    };
	    
	    Integer cost[] = new Integer[n];
	    Integer dest[] = new Integer[n];
	    
	    cost[n-1] = 0;
	    dest[n-1] = n-1;
	    
	    for (int i=n-1; i>=0; i--) {
	        for (int j=i+1; j<=n-1; j++) {
	            if (arr[i][j] != null) {
	                if (cost[i] == null) {
	                    cost[i] = arr[i][j] + cost[j];
	                    dest[i] = j;
	                } else {
	                    if (cost[i] > (arr[i][j] + cost[j])) {
                          cost[i] = arr[i][j] + cost[j];
	                      dest[i] = j;    	                        
	                    }
	                }
	            }
	        }
	    }
		    
		for (int k = 0; k<n; k++) {
		    System.out.println("node = " + k + " --> cost = " + cost[k] + " dest = " + dest[k]);
		}
		
		System.out.println("Finding shortest path...");
		System.out.print("0");
		int p=0;
		while (p<n-1) {
		    System.out.print("-->" + dest[p]);
		    p = dest[p];
		}
		
	}
}
