package Test1;

import java.util.Arrays;
import java.util.Scanner;
public class Dijkstra {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int m=sc.nextInt();
        int map[][]=new int[n+1][n+1];
        for(int i=0;i<n+1;i++){//初始化所有点相互不可达为-1
            for(int j=0;j<n+1;j++){
                map[i][j]=-1;
            }
        }
        int s[][]=new int[n+1][n+1];//点不可达的起始时间
        int e[][]=new int[n+1][n+1];//点不可达的终止时间
        for(int i=0;i<m;i++){
            int p=sc.nextInt();
            int q=sc.nextInt();
            int k=sc.nextInt();
            int x=sc.nextInt();
            int y=sc.nextInt();
            map[p][q]=k;//两个港有航线则两个点双向可达,边的大小为时间
            map[q][p]=k;
            s[p][q]=x;
            s[q][p]=x;
            e[p][q]=y;
            e[q][p]=y;
        }
        sc.close();
        System.out.println(dijkstra(map,s,e,n));
    }
    /*
     * DijStra是求最短路径的算法。算法步骤：
     * 初始集合只包括一个源点V,然后把距离v最小的点u加入集合,再把距离距离u最小的点加入集合,如此递归,直到所有点都在集合中
     */
    public static int dijkstra(int[][]map,int [][]s,int [][]e,int n){
        int dist[]=new int[n+1];
        boolean vis[]=new boolean[n+1];
        Arrays.fill(dist,Integer.MAX_VALUE);
        dist[1]=0;
        for(int i=1;i<=n;i++){
            int min=Integer.MAX_VALUE;
            int v=1;
            for(int j=1;j<=n;j++){//找到下一个点
                if(!vis[j]&&dist[j]<min){
                    min=dist[j];
                    v=j;
                }
            }
            vis[v]=true;
            for(int k=1;k<=n;k++){
                if(!vis[k]&&map[v][k]!=-1){
                    int tmp=dist[v]+map[v][k];
                    if(tmp<s[v][k]){//在不可到达的时间前到达了
                        dist[k]=Math.min(tmp,dist[k]);
                    }else{//在不可到达的时间段内到达
                        if(dist[v]>e[v][k]){//在前往k前已经过了不可到达时间
                            dist[k]=Math.min(tmp,dist[k]);
                        }else{//在不可通行的时间范围内到达,则只能暴风雨过后再出发
                            dist[k]=Math.min(dist[k],e[v][k]+map[v][k]);
                        }
                    }
                }
            }
        }
        return dist[n]+1;//dist[n]为到达n需要几天,答案是第几天
    }
}
