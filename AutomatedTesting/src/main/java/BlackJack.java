
public class BlackJack {
	
	public int play(int a, int b) {
		if (a>21 && b>21) {
			return b;
		}
		else if(a<2 || b<2) {
			return -1;
		}
		else if (a>21 && b<=21) {
			return b;
		}
		else if(a<=21 && b>21) {
			return a;
		}
		else if(a<=21 && b<=21) {
			if (a>b) {
				return a;
			}
			else {
				return b;
			}
		}
		return 0;
	}
}
