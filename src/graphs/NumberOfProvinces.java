package graphs;

public class NumberOfProvinces {
    public static int findCircleNum(int[][] isConnected) {
        int count = 0;
        for(int i = 0; i < isConnected.length; i++) {
            for(int j = 0; j < isConnected[i].length; j++) {
                if(isConnected[i][j] == 1 || isConnected[j][j] == 1) {
                    count++;
                    isConnected[i][j] = isConnected[j][i] = 0;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {

    }
}
