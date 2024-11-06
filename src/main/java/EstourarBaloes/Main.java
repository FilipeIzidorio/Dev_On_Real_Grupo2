package EstourarBaloes;

public class Main {
    public static int maxCoins(int[] nums) {
        int n = nums.length;
        int[] balao = new int[n + 2];

        // Inicializa balao com 1 nos limites e nums no meio
        balao[0] = balao[n + 1] = 1;
        for (int i = 1; i <= n; i++) {
            balao[i] = nums[i - 1];
        }

        // dp[i][j] armazena o número máximo de moedas de estourar balões entre i e j
        int[][] dp = new int[n + 2][n + 2];

        // Preenche dp para intervalos de comprimento crescente
        for (int length = 1; length <= n; length++) {
            for (int left = 1; left <= n - length + 1; left++) {
                int right = left + length - 1;

                // Itera sobre todos os possíveis "últimos balões" a serem estourados no intervalo
                for (int i = left; i <= right; i++) {
                    int coins = balao[left - 1] * balao[i] * balao[right + 1];
                    coins += dp[left][i - 1] + dp[i + 1][right];
                    dp[left][right] = Math.max(dp[left][right], coins);
                }
            }
        }

        return dp[1][n];
    }

    public static void main(String[] args) {
        int[] nums = {3, 1, 5, 8};
        int resultado = maxCoins(nums);
        System.out.println(resultado); // Saída esperada: 167
    }
}

