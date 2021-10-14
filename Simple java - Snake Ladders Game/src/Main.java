import java.util.Scanner;
//andres - 2301876386
public class Main {
	Scanner in = new Scanner(System.in);
	int turn = 0;
	int p1valTemp = 0, p2valTemp = 0, p3valTemp = 0;
	int p1val[] = new int [26];
	int p2val[] = new int [26];
	int p3val[] = new int [26];
	int dice1[] = new int [26];
	int dice2[] = new int [26];
	int dice3[] = new int [26];
	int idx = 1;
	public void prompt() {
		System.out.println("Press ENTER to roll the Dice!");
		in.nextLine();
		System.out.println("");
	}
	
	public void petc() {
		System.out.println("Press ENTER to continue..");
		in.nextLine();
	}
	
	public int dice() {
		return (int)(Math.random()*6)+1;
	}
	
	public void play1() {
		idx = 1;
		do {
			turn++;
			System.out.printf("~Turn %d\n",turn);
			int temp = 0;
			System.out.println("Player 1's Turn!");
			System.out.printf("Player 1 is %d steps away from winning\n\n",(100-p1valTemp));
			prompt();
			temp = dice();
			System.out.printf("Player 1 rolled %d\n",temp);
			p1valTemp+=temp;
			dice1[idx] = temp;
			
			if(p1valTemp > 100) {
				System.out.printf("Oops, went ahead %d steps", 100-p1valTemp);
				p1valTemp = 100-(p1valTemp-100);
			}
			
			if(p1valTemp == 13) {
				p1valTemp = 7;
				System.out.println("Stepped on a snake, and now you're back to step 7");
			} else if (p1valTemp == 25) {
				p1valTemp = 40;
				System.out.println("You founded a ladder to go up!, you're now at step 40");
			} else if (p1valTemp == 50) {
				p1valTemp = 38;
				System.out.println("Stepped on a snake, and now you're back to step 38");
			} else if (p1valTemp == 63) {
				p1valTemp = 78;
				System.out.println("You founded a ladder to go up!, you're now at step 78");
			} else if (p1valTemp == 83) {
				p1valTemp = 97;
				System.out.println("You founded a ladder to go up!, you're now at step 97");
			} else if (p1valTemp == 95) {
				p1valTemp = 76;
				System.out.println("Stepped on a snake, and now you're back to step 76");
			}
			p1val[idx] = p1valTemp;
			petc();
			
			temp = 0;
			System.out.println("Player 2's Turn!");
			System.out.printf("Player 2 is %d steps away from winning\n\n",(100-p2valTemp));
			prompt();
			temp = dice();
			System.out.printf("Player 2 rolled %d\n",temp);
			p2valTemp+=temp;
			dice2[idx] = temp;
			
			
			if(p2valTemp > 100) {
				System.out.printf("Oops, went ahead %d steps", 100-p2valTemp);
				p2valTemp = 100-(p2valTemp-100);
			}
			
			if(p2valTemp == 13) {
				p2valTemp = 7;
				System.out.println("Stepped on a snake, and now you're back to step 7");
			} else if (p2valTemp == 25) {
				p2valTemp = 40;
				System.out.println("You founded a ladder to go up!, you're now at step 40");
			} else if (p2valTemp == 50) {
				p2valTemp = 38;
				System.out.println("Stepped on a snake, and now you're back to step 38");
			} else if (p2valTemp == 63) {
				p2valTemp = 78;
				System.out.println("You founded a ladder to go up!, you're now at step 78");
			} else if (p2valTemp == 83) {
				p2valTemp = 97;
				System.out.println("You founded a ladder to go up!, you're now at step 97");
			} else if (p2valTemp == 95) {
				p2valTemp = 76;
				System.out.println("Stepped on a snake, and now you're back to step 76");
			}
			p2val[idx] = p2valTemp;
			petc();
			idx++;
		}while(turn < 25 && p1valTemp != 100 && p2valTemp !=100);
		
			System.out.println(" _____________________________________________");
			System.out.println("| Round |     Player 1     |     Player 2     |");
			System.out.println("|       | Old | Dice | New | Old | Dice | New |");
			System.out.println("|||||||||||||||||||||||||||||||||||||||||||||||");
			for(int i = 1; i<=turn; i++){
				System.out.printf("|%4d   |%4d |%5d |%4d |%4d |%5d |%4d |\n",i,p1val[i]-dice1[i],dice1[i],p1val[i],p2val[i]-dice2[i],dice2[i],p2val[i]);
			}
			System.out.println("|||||||||||||||||||||||||||||||||||||||||||||||");
			petc();
			
			System.out.println("The game has Ended");
			if(p1val[turn]>p2val[turn]) {
				System.out.printf("#1 Player 1 - %d\n",p1val[turn]);
				System.out.printf("#2 Player 2 - %d\n",p2val[turn]);
			} else {
				System.out.printf("#1 Player 2 - %d\n",p2val[turn]);
				System.out.printf("#2 Player 1 - %d\n",p1val[turn]);				
			}
			System.out.println();
			
			petc();
			p1valTemp = 0;
			p2valTemp = 0;
			for(int i = 1; i<=turn; i++) {
				p1val[i] = 0;
				p2val[i] = 0;
				dice1[i] = 0;
				dice2[i] = 0;
			}
	}
	
	public void play2() {
		idx = 1;
		do {
			turn++;
			System.out.printf("~Turn %d\n",turn);
			int temp = 0;
			System.out.println("Player 1's Turn!");
			System.out.printf("Player 1 is %d steps away from winning\n\n",(100-p1valTemp));
			prompt();
			temp = dice();
			System.out.printf("Player 1 rolled %d\n",temp);
			p1valTemp+=temp;
			dice1[idx] = temp;
			
			if(p1valTemp > 100) {
				System.out.printf("Oops, went ahead %d steps", 100-p1valTemp);
				p1valTemp = 100-(p1valTemp-100);
			}
			
			if(p1valTemp == 13) {
				p1valTemp = 7;
				System.out.println("Stepped on a snake, and now you're back to step 7");
			} else if (p1valTemp == 25) {
				p1valTemp = 40;
				System.out.println("You founded a ladder to go up!, you're now at step 40");
			} else if (p1valTemp == 50) {
				p1valTemp = 38;
				System.out.println("Stepped on a snake, and now you're back to step 38");
			} else if (p1valTemp == 63) {
				p1valTemp = 78;
				System.out.println("You founded a ladder to go up!, you're now at step 78");
			} else if (p1valTemp == 83) {
				p1valTemp = 97;
				System.out.println("You founded a ladder to go up!, you're now at step 97");
			} else if (p1valTemp == 95) {
				p1valTemp = 76;
				System.out.println("Stepped on a snake, and now you're back to step 76");
			}
			p1val[idx] = p1valTemp;
			petc();
			
			temp = 0;
			System.out.println("Player 2's Turn!");
			System.out.printf("Player 2 is %d steps away from winning\n\n",(100-p2valTemp));
			prompt();
			temp = dice();
			System.out.printf("Player 2 rolled %d\n",temp);
			p2valTemp+=temp;
			dice2[idx] = temp;
			
			
			if(p2valTemp > 100) {
				System.out.printf("Oops, went ahead %d steps", 100-p2valTemp);
				p2valTemp = 100-(p2valTemp-100);
			}
			
			if(p2valTemp == 13) {
				p2valTemp = 7;
				System.out.println("Stepped on a snake, and now you're back to step 7");
			} else if (p2valTemp == 25) {
				p2valTemp = 40;
				System.out.println("You founded a ladder to go up!, you're now at step 40");
			} else if (p2valTemp == 50) {
				p2valTemp = 38;
				System.out.println("Stepped on a snake, and now you're back to step 38");
			} else if (p2valTemp == 63) {
				p2valTemp = 78;
				System.out.println("You founded a ladder to go up!, you're now at step 78");
			} else if (p2valTemp == 83) {
				p2valTemp = 97;
				System.out.println("You founded a ladder to go up!, you're now at step 97");
			} else if (p2valTemp == 95) {
				p2valTemp = 76;
				System.out.println("Stepped on a snake, and now you're back to step 76");
			}
			p2val[idx] = p2valTemp;
			petc();
			
			temp = 0;
			System.out.println("Player 3's Turn!");
			System.out.printf("Player 3 is %d steps away from winning\n\n",(100-p3valTemp));
			prompt();
			temp = dice();
			System.out.printf("Player 3 rolled %d\n",temp);
			p3valTemp+=temp;
			dice3[idx] = temp;
			
			
			if(p3valTemp > 100) {
				System.out.printf("Oops, went ahead %d steps", 100-p3valTemp);
				p3valTemp = 100-(p3valTemp-100);
			}
			
			if(p3valTemp == 13) {
				p3valTemp = 7;
				System.out.println("Stepped on a snake, and now you're back to step 7");
			} else if (p3valTemp == 25) {
				p3valTemp = 40;
				System.out.println("You founded a ladder to go up!, you're now at step 40");
			} else if (p3valTemp == 50) {
				p3valTemp = 38;
				System.out.println("Stepped on a snake, and now you're back to step 38");
			} else if (p3valTemp == 63) {
				p3valTemp = 78;
				System.out.println("You founded a ladder to go up!, you're now at step 78");
			} else if (p3valTemp == 83) {
				p3valTemp = 97;
				System.out.println("You founded a ladder to go up!, you're now at step 97");
			} else if (p3valTemp == 95) {
				p3valTemp = 76;
				System.out.println("Stepped on a snake, and now you're back to step 76");
			}
			p3val[idx] = p3valTemp;
			petc();
			
			idx++;
		}while(turn < 25 && p1valTemp != 100 && p2valTemp !=100);
		
			System.out.println(" ________________________________________________________________");
			System.out.println("| Round |     Player 1     |     Player 2     |     Player 3     |");
			System.out.println("|       | Old | Dice | New | Old | Dice | New | Old | Dice | New |");
			System.out.println("||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||");
			for(int i = 1; i<=turn; i++){
				System.out.printf("|%4d   |%4d |%5d |%4d |%4d |%5d |%4d |%4d |%5d |%4d |\n",i,p1val[i]-dice1[i],dice1[i],p1val[i],p2val[i]-dice2[i],dice2[i],p2val[i],p3val[i]-dice3[i],dice3[i],p3val[i]);
			}
			System.out.println("||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||");
			petc();
			
			System.out.println("The game has Ended");
			if(p1val[turn]>p2val[turn]&&p1val[turn]>p3val[turn]) {
				System.out.printf("#1 Player 1 - %d\n",p1val[turn]);
				if(p2val[turn]>p3val[turn]) {
					System.out.printf("#2 Player 2 - %d\n",p2val[turn]);
					System.out.printf("#3 Player 3 - %d\n",p3val[turn]);
				} else {
					System.out.printf("#2 Player 3 - %d\n",p3val[turn]);
					System.out.printf("#3 Player 2 - %d\n",p2val[turn]);
				}
			} else if (p2val[turn]>p1val[turn] && p2val[turn]>p3val[turn]) {
				System.out.printf("#1 Player 2 - %d\n",p2val[turn]);
				if(p1val[turn]>p3val[turn]) {
					System.out.printf("#2 Player 1 - %d\n",p1val[turn]);
					System.out.printf("#3 Player 3 - %d\n",p3val[turn]);
				} else {
					System.out.printf("#2 Player 3 - %d\n",p3val[turn]);
					System.out.printf("#3 Player 1 - %d\n",p1val[turn]);
				}				
			} else if (p3val[turn]>p1val[turn] && p3val[turn]>p2val[turn]) {
				System.out.printf("#1 Player 3 - %d\n",p3val[turn]);
				if(p2val[turn]>p1val[turn]) {
					System.out.printf("#2 Player 2 - %d\n",p2val[turn]);
					System.out.printf("#3 Player 1 - %d\n",p1val[turn]);
				} else {
					System.out.printf("#2 Player 1 - %d\n",p1val[turn]);
					System.out.printf("#3 Player 2 - %d\n",p2val[turn]);
				}
			} else {
				System.out.println("Whoa you got a unique result for playing an randomized snake game");
				System.out.println("Congratulations !, you can count the rank by yourself.");
			}
			System.out.println();
			
			petc();
			p1valTemp = 0;
			p2valTemp = 0;
			p3valTemp = 0;
			for(int i = 1; i<=turn; i++) {
				p1val[i] = 0;
				p2val[i] = 0;
				p3val[i] = 0;
				dice1[i] = 0;
				dice2[i] = 0;
				dice3[i] = 0;
			}
	}
	
	public Main() {
		// TODO Auto-generated constructor stub
		int input = 0;
		do {
			input = 0;
			System.out.println("---Welcome to Snake Ladders---");
			System.out.println("1. --2 Player Game--");
			System.out.println("2. --3 Player Game--");
			System.out.println("3. --Exit--");
			try {
				input = in.nextInt();
				in.nextLine();
			}catch(Exception e) {
				in.nextLine();
			}
			if(input == 1) {
				turn = 0;
				play1();
			}else if (input == 2) {
				turn = 0;
				play2();
			}
		}while(input != 3);
		System.out.println("ThankYou for playing!");
	}

	public static void main(String[] args) {
		new Main();
	}
}
