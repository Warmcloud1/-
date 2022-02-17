//if的代替手法

		int time=16; //輸出上述都沒執行到
		int time=12; //輸出12點 18點 表示找到12後往下執行

		switch(time){
			case 7:
				System.out.println("7點");
				
			case 12:
				System.out.println("12點");
				
			case 18:
				System.out.println("18點");
				break;
			case 22:
				System.out.println("22點");

			default:
				System.out.println("上述都沒執行到");
		}

}
