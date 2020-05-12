import java.util.Arrays;
public class AssignCookies{
	public int findContentChildren(int[] g, int[] s){
		if(g==null||s==null){return 0;}
        Arrays.sort(g);
        Arrays.sort(s);
        int gi=0, sj=0;
        while(gi<g.length && sj<s.length){
            if(s[sj] >= g[gi]){
                gi++;
            }
            sj++;
        }
        return gi;
	}
}
//https://leetcode.com/problems/assign-cookies/description/