Contest Question : Prime factors. given an array of queries, find the count of numbers having min prime factor B[i].

public class Solution {
    public ArrayList<Integer> solve(int A, ArrayList<Integer> B) {
        
            //spf creation
        ArrayList<Integer> spf = new ArrayList<>();
        int range = 1000000;
        spf.add(-1);
        spf.add(-1);
        
        for(int i=2; i<=range; i++){
            spf.add(i);
        }
        
        for(int i=2; i*i<=range; i++){
            if(spf.get(i)==i){
                for(int j=i*i; j<=range; j+=i){
                    if(spf.get(j)==j){
                        spf.set(j, i);
                    }
                }
            }
        }
        
        HashMap<Integer, Integer> map = new HashMap<>();
        ArrayList<Integer> ans = new ArrayList<>();
        
        for(int i=0; i<=range; i++){
            int num = spf.get(i);
            if(map.containsKey(num)){
                map.put(num, map.get(num)+1);
            }else{
                map.put(num, 1);
            }
        }
        
        for(int i=0; i<A; i++){
            int query = B.get(i);
            if(map.containsKey(query)){
                ans.add(map.get(query));
            }
        }
        
        return ans;
        
        
    
    }
}
