public class CoinChangeProblem {

    public static void sum(int[] combination, int coin) {

        for(int i=1; i<combination.length; i++){
            int sumLeft = i - coin;
            if(sumLeft >= 0) {

		int currentValue = combination[i];
		int totalValue = currentValue + combination[sumLeft];
		combination[i] = totalValue;
	    }
	}
    }

    public static void main(String[] args) {

        int[] x = {1,2,5};
        int length = x.length;
        int sum = 12;

        int[] combination = new int[sum+1];
        combination[0] = 1;

        for(int i=0; i<length; i++){
            int currentCoin = x[i];
            sum(combination, currentCoin);
	}

	for(int val: combination){
	    System.out.print(val);
	    System.out.print(",");
	}

    }
}
