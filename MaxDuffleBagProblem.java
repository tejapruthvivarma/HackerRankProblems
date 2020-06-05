
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MaxDuffleBagProblem {


static int maxDuffelBagValue(List<List<Integer>> CakesList, int capacity) {
    int maxValue= 0;
    int remainingCapacity = capacity;
    
    int secondBestValue = 0;
    

    
    
    do{
    	int tempRemaning = remainingCapacity;
    	int tempMaxValue = 0;
    	int secondBestIndex = 0;
    	secondBestValue = 0;
        int tempMaxIndex = CakesList.size();
    for (int i=0;i<CakesList.size();i++){
    	
    	
    	int value = (remainingCapacity/CakesList.get(i).get(0)) * (CakesList.get(i).get(1));
    	
    	
    	if( value > tempMaxValue ) {
    		tempMaxValue = value;
    		 tempRemaning = remainingCapacity - ( (remainingCapacity/CakesList.get(i).get(0) ) * (CakesList.get(i).get(0)));
    		 tempMaxIndex = i;
    		 
    		
    		
    	}
    	
    	if(tempMaxIndex ==i){
    		if(tempRemaning / CakesList.get(secondBestIndex).get(0) > 0){
    			secondBestIndex = i;
    			secondBestValue = value;
    			
    		}
    		
    		
    	}
    	
    	else {
    		if(tempRemaning / CakesList.get(i).get(0) > 0 & value >secondBestValue){
    			secondBestIndex = i;
    			secondBestValue = value;
    			
    		}
    	}
    		
    		if(i == CakesList.size()-1 ){
    	maxValue +=tempMaxValue;
    	remainingCapacity = tempRemaning;
    	CakesList.remove(tempMaxIndex);
    	
    		}
    	
    	
    }
    }
    while(secondBestValue > 0);
    
    
   return maxValue;
        }


 

    public static void main(String[] args) throws IOException {
       
        List<Integer> Cake1 = new ArrayList<Integer>();
        Cake1.add(0,7);
        Cake1.add(1,160);
        
        List<Integer> Cake2 = new ArrayList<Integer>();
        Cake2.add(0,3);
        Cake2.add(1,90);
        
        List<Integer> Cake3 = new ArrayList<Integer>();
        Cake3.add(0,5);
        Cake3.add(1,15);
        
        List<Integer> Cake4 = new ArrayList<Integer>();
        Cake4.add(0,1);
        Cake4.add(1,10);
        
        
        List<List<Integer>> CakesList = new ArrayList<List<Integer>>();
        
        CakesList.add(Cake1);
       CakesList.add(Cake2);
        CakesList.add(Cake3);
        CakesList.add(Cake4);
        
      System.out.println(maxDuffelBagValue(CakesList, 20));

    }
}
