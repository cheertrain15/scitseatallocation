package UI;

import java.util.Random;

public class LottoUI {

	private Random ran = new Random();
	private int[] selection = new int[6];

	public LottoUI() {
		System.out.println("The lucky numbers of the week");
		for (int i = 0; i < 5; i++) {
			selection[0] = ran.nextInt(45) + 1;
			do {
				selection[1] = ran.nextInt(45) + 1;
			} while (selection[0] == selection[1]);

			do {
				selection[2] = ran.nextInt(45) + 1;
			} while ((selection[0] == selection[2]) || (selection[1] == selection[2]));

			do {
				selection[3] = ran.nextInt(45) + 1;
			} while ((selection[0] == selection[3]) || (selection[1] == selection[3])
					|| (selection[2] == selection[3]));

			do {
				selection[4] = ran.nextInt(45) + 1;
			} while ((selection[0] == selection[4]) || (selection[1] == selection[4]) || (selection[2] == selection[4])
					|| (selection[3] == selection[4]));

			do {
				selection[5] = ran.nextInt(45) + 1;
			} while ((selection[0] == selection[5]) || (selection[1] == selection[5]) || (selection[2] == selection[5])
					|| (selection[3] == selection[5]) || (selection[4] == selection[5]));

			for (int l = 0; l < selection.length; l++) {
				for (int j = 0; j < selection.length - 1; j++) {
					if (selection[j] > selection[j + 1]) {
						int[] temp = new int[1];
						temp[0] = selection[j];
						selection[j] = selection[j + 1];
						selection[j + 1] = temp[0];
					}
				}
			}

			for (int k = 0; k < selection.length; k++) {
				System.out.print(selection[k] + "\t");
			}
			System.out.println("");
			ran.nextInt();
		}
	}
}
