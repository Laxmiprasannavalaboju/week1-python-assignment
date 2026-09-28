import java.util.*;

public class Main{
static class C{
int a,b;
String d;
C(int a,int b,String d){this.a=a;this.b=b;this.d=d;
}
}
public static void main(String[] args){
Scanner sc=new Scanner(System.in);
int n=sc.nextInt();
ArrayList<C> list=new ArrayList<>();
for(int i=0;i<n;i++)list.add(new C(sc.nextInt(),sc.nextInt(),sc.next()));
int target=sc.nextInt();
list.sort((x,y)->x.a!=y.a?x.a-y.a:x.b-y.b);
Map<Integer,int[]> pos=new HashMap<>();
Map<String,Integer> board=new HashMap<>();
pos.put(1,new int[]{0,0});
board.put("0,0",1);
for(C c:list){
int[] p=pos.get(c.a);
if(p==null)continue;
int x=p[0],y=p[1];
if(c.d.equals("right"))x++;
else if(c.d.equals("left"))x--;
else if(c.d.equals("top"))y++;
else if(c.d.equals("down"))y--;
String key=x+","+y;
Integer old=board.get(key);
if(old!=null)pos.remove(old);
board.put(key,c.b);
pos.put(c.b,new int[]{x,y});
}
int[] p=pos.get(target);
int[][] move={{0,1},{0,-1},{-1,0},{1,0}};
for(int i=0;i<4;i++){
String key=(p[0]+move[i][0])+","+(p[1]+move[i][1]);
System.out.print(board.getOrDefault(key,-1)+(i==3?"\n":" "));
}
}
}