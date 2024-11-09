class Solution {
List<List<Integer>> res=new ArrayList<>();

public List<List<Integer>> permuteUnique(int[] nums) {
boolean[] vis=new boolean[nums.length];
util(nums, new ArrayList<>(), vis);
return res;
}

public void util(int[] nums, List<Integer> list, boolean[] vis) {
if(list.size()==nums.length) {
if (!res.contains(list)) {
res.add(new ArrayList<>(list));
}
return;
}
for(int i=0; i<nums.length; i++) {
if(vis[i])
continue;
if (i != 0 && nums[i] == nums[i - 1] && !vis[i - 1]) {
continue;
}
vis[i]=true;
list.add(nums[i]);
util(nums, list, vis);
vis[i]=false;
list.remove(list.size()-1);
}
}
}