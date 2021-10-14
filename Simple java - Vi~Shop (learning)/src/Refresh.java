import java.util.Random;
public class Refresh implements Runnable{

	Thread th;
	module i;
	private int hour;

	public Refresh(module i, int delivery) {
		this.i = i;
		i.setStatus("On-Going");

		//ongkir 0 berarti VeDex, ongkir 1 berarti ViCepat
		if(delivery == 1) {
			this.hour = 24; 
			i.setType("ViCepat");
		} else {
			this.hour = 48;
			i.setType("VeDex");
		}
		th = new Thread(this);
		Main_UAP.info.add(i);
		th.start();
	}

	@Override
	public void run() {	
		Random temp  = new Random();
		while(hour != 0) {
			hour--;
			if(i.getType().equalsIgnoreCase("vedex")) {
				int rand = temp.nextInt(10);
				if(rand == 0) {
					i.setStatus("Failed");
					break;
				}
			}	
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		if(hour == 0) {
			i.setStatus("Completed");
			Main_UAP.completed.add(i);
			Main_UAP.info.remove(i);
			try {
				Main_UAP.refresh.remove(i);
			}
			catch ( Exception e) {
				
			}
		}
		
	}
}
