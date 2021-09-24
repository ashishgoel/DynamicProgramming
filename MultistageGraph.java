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

*******************************************************************************/

public class MultistageGraph
{
	public static void main(String[] args) {
		System.out.println("Hello World");
		
		Integer[][] arr= {
		    { null, 3,       2, null },
		    { null, null, null,    4 },
		    { null, null, null,    6 },
		    { null, null, null, null }
	    };
	    
	    Integer cost[] = new Integer[4];
	    Integer dest[] = new Integer[4];
	    
	    cost[3] = 0;
	    dest[3] = 3;
	    
	    for (int i=2; i>=0; i--) {
	        for (int j=i+1; j<=3; j++) {
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
		    
		for (int k = 0; k<4; k++) {
		    System.out.println("node = " + k + " --> cost = " + cost[k] + " dest = " + dest[k]);
		}
		
		System.out.println("Finding shortest path...");
		System.out.print("0");
		for (int p=0; p<4; p++) {
		    System.out.print("-->" + dest[p]);
		    p = dest[p];
		}
		
	}
}
