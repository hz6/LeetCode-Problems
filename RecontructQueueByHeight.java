public class ReconstructQueueByHeight{
	public int[][] reconstructQueue(int[][] people){
		if (people == null || people.length == 0 || people[0].length == 0) {
            return new int[0][0];
        }
        Arrays.sort(people, new Comparator<int[]>(){
            @Override
            public int compare(int[] arr1, int[] arr2){
                if (arr1[0]==arr2[0]) {
                    return arr1[1]-arr2[1];
                } else {
                    return arr2[0]-arr1[0];
                }
            }
        });
        List<int[]> queue = new ArrayList<int[]>();
        for (int[] p : people) {
            queue.add(p[1], p);
        }
        return queue.toArray(new int[queue.size()][]);
	}
}
// https://leetcode.com/problems/queue-reconstruction-by-height/description/
/*
input origin:[[7,0], [4,4], [7,1], [5,0], [6,1], [5,2]]
if height is the same, then put the one with bigger k behind 
按照身高(k)降序排列, 若身相等则按照前面的人数(k)升序排列
sorted by height:[[7,0], [7,1], [6,1], [5,0], [5,2], [4,4]]
*/