// labb 5, DD1380
// med BFS

import java.util.*;

public class Island {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int rader = sc.nextInt();
        int kolumner = sc.nextInt();

        // skapar matrisen
        int M[][] = new int[rader][kolumner]; 

        // stoppar in värden
        for (int i = 0; i < rader; i++) { 

            String rad = sc.next();
            char[] tokens = rad.toCharArray();

            for (int j = 0; j < kolumner; j++) {

				// enklare med 1:or och 0:or
                if (tokens[j] == '@') {
                    M[i][j] = 1;
                } else {
                    M[i][j] = 0;
                }

				//System.out.println(M[i][j]);
            } 
        }
        sc.close();

        // beräknar antal öar
		System.out.print(countIslands(M, rader, kolumner));
        System.out.print("\n");
	}

	public static int countIslands(int[][] M, int rader, int kolumner) {

		// basvillkor
		if (M == null || rader == 0 || kolumner == 0) {
			return 0;
		}	

		// test
		boolean[][] visited = new boolean[rader][kolumner];

		int count = 0;
		
		for (int i = 0; i < rader; i++) {

			for (int j = 0; j < kolumner; j++) {

				if (M[i][j] == 1 && !visited[i][j]) {

					count++;
					BFS(visited, i, j, M, rader, kolumner);
				}
			}
		}
		return count;
	}

	public static void BFS(boolean[][] visited, int i, int j, int[][] M, int rader, int kolumner) {

		//[i,j] som representerar varje punkt
		Queue<List<Integer>> queue = new LinkedList<>();
		queue.offer(Arrays.asList(i, j));
		visited[i][j] = true;
		
		while (!queue.isEmpty()) {

			List<Integer> cur = queue.poll();

			int ny_i = cur.get(0);
			int ny_j = cur.get(1);

			//ner
			if (isValidNeighbor(M, ny_i + 1, ny_j, visited, rader, kolumner)) {

				queue.offer(Arrays.asList(ny_i + 1, ny_j));

				visited[ny_i + 1][ny_j] = true;
			}

			//upp
			if (isValidNeighbor(M, ny_i - 1, ny_j, visited, rader, kolumner)) {

				queue.offer(Arrays.asList(ny_i - 1, ny_j));
				visited[ny_i - 1][ny_j] = true;
			}

			//höger
			if (isValidNeighbor(M, ny_i, ny_j + 1, visited, rader, kolumner)) {

				queue.offer(Arrays.asList(ny_i, ny_j + 1));
				visited[ny_i][ny_j + 1] = true;
			}

			//vänster
			if (isValidNeighbor(M, ny_i, ny_j - 1, visited, rader, kolumner)) {

				queue.offer(Arrays.asList(ny_i, ny_j - 1));
				visited[ny_i][ny_j - 1] = true;
			}
		}
	}

	// testar om granne, granne om:
	// 1. innanför gränser; 2. inte upprepning; 3. == '1';
	
	public static boolean isValidNeighbor(int[][] M, int i, int j, boolean[][] visited, int rader, int kolumner) {
		
		// villkor
		if (i < 0 || j < 0 || i >= rader || j >= kolumner || visited[i][j] == true || M[i][j] == 0) {
			return false;
		} else {
			return true;
		}
		
	}

}






