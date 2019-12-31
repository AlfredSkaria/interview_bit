import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.List;

public class SubArraySum{

    static int[] arr = new int[] {3,7,2,1,20};
    static int k = 10;

    private void insertIntoMap(Map<Integer, List<Integer>> sumByIndicesMap, Integer key, Integer value){
        if(!sumByIndicesMap.containsKey(key)){
            sumByIndicesMap.put(key, new ArrayList<>());
        }

        sumByIndicesMap.get(key).add(value);
    }

    int subArrayWithGivenSum(int[] arr, int sum){
        
            Map<Integer, List<Integer>> sumByIndicesMap = new HashMap<>();
            int currentSum = 0;
            int output = 0;
            insertIntoMap(sumByIndicesMap, 0, -1);
            for(int i = 0; i < arr.length ; i ++){
                currentSum += arr[i];
        
                if(sumByIndicesMap.containsKey(currentSum-sum)){
                    List<Integer> values = sumByIndicesMap.get(currentSum-sum);
                    if(values != null){
                        output = output + values.size();
                    }
                    
                }
                
                insertIntoMap(sumByIndicesMap, currentSum, i);
                
                

            }
        return output;
    }

    public static void main(String args[]){
        SubArraySum s = new SubArraySum();
        int output = s.subArrayWithGivenSum(arr, k);
        System.out.println(output);
    }
}