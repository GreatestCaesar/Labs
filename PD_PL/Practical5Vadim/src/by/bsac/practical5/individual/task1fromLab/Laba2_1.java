package by.bsac.practical5.individual.task1fromLab;

import java.util.ArrayList;
import java.util.List;
public class Laba2_1 {
	public static void main(String[] args){
		List<Stone> stoneList = new ArrayList<Stone>();
		double i;
		double totalPreciousWeight = 0, totalPreciousPrice = 0;
		double totalSemiPreciousWeight = 0, totalSemiPreciousPrice = 0;
		for (i = 0; i < 20; i += 3)
			stoneList.add(new PreciousStone("preciousStone" + i, i / 10 + i / 100, i * 1000));
		for (i = 1; i < 2; i += 3)
			stoneList.add(new SemiPreciousStone("semiPreciousStone" + i, i / 5 + i / 150, i * 120 + i / 7));
		/*for (int b =0; b<20;b++){
		System.out.println(stoneList.get(b));
		} */
		for (Stone stone : stoneList)
			if (stone instanceof PreciousStone) {
				totalPreciousWeight += stone.getWeight();
				totalPreciousPrice += stone.getPrice();
			} else if (stone instanceof SemiPreciousStone) {
				totalSemiPreciousWeight += stone.getWeight();
				totalSemiPreciousPrice += stone.getPrice();
			}
		stoneList.clear();

			try {                                                                        // создание собвстенного исключения, если убрать try{}catch будет возникать ошибка
				if (totalSemiPreciousWeight < 1) {
					throw new MyException(totalSemiPreciousWeight);
				}
			}catch (Exception e) {
				System.out.println(e);
			}
			System.out.println("Precious necklace: \n Total Weight: " + totalPreciousWeight + ";\nTotal Price: " + totalPreciousPrice + "\n");
			System.out.println("SemiPrecious necklace: \n Total Weight: " + totalSemiPreciousWeight + ";\nTotal Price: " + totalSemiPreciousPrice + "\n");
	}
}
