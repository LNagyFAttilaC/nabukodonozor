package grafikus;

public class Help {

	private String help = "A játék a Gyûrûk Ura témáján alapul. Típusát tekintve tower defense, stratégiai játék.\n"
			+ "A játék során négy fajta, különbözõ fajból származó ellenségekkel kell felvenni a harcot "
			+ "(tündék, emberek, törpök, hobbitok). Ezeknek különbözõ értékû tulajdonságaik vannak, de fajonként "
			+ "azonosak. A tulajdonságok megnevezései: életerõ, sebesség, elpusztításakor szerezhetõ varázserõ (az ellenség értéke)."
			+ "A játék elején a játékos több pálya közül választhat. Ezután elindul a játék.\n"
			+ "A játékos célja, hogy megakadályozza, hogy a hobbitok, tündék, törpök, emberek eljuttassák az Egy Gyûrût"
			+ "a Végzet Hegyéhez.\n"
			+ "Ennek érdekében tornyokat építhet, melyek lövik a pályán mozgó ellenségeket, ha azok belépnek a torony hatósugarába.\n"
			+ "A játékban egy fajta torony építhetõ, csak és kizárólag mezõre. A tornyok kezdetben azonos tulajdonságokkal rendelkeznek."
			+ "Minden torony tulajdonságait lehet növelni varázskövekkel. Minden varázskõ pontosan egy"
			+ "tulajdonság növeléséért felelõs. Ilyenek az alap sebzést növelõ kövek, az egyes fajokra gyakorolt sebzést növelõ "
			+ "kövek (külön a tündékre, külön az emberekre, külön a törpökre és külön a hobbitokra), "
			+ "a torony tüzelési frekvenciáját növelõ és végül a torony hatótávolságát növelõ kövek. "
			+ "Egy torony több varázskövet is kaphat, ezek lehetnek különbözõek is. "
			+ "Egy adott varázskõ vagy csak toronyhoz, vagy csak akadályhoz használható.\n"
			+ "Tornyok és csapdák építéséhez, valamint varázskövek készítéséhez a rendelkezésre álló manát lehet használni.\n"
			+ "Ez a varázserõ ellenségek elpusztításával növekszik, míg torony, csapda vagy kõ elhelyezésekor csökken "
			+ "a dolgok árának megfelelõen. Toronyból, csapdából, kõbõl bármennyi varázsolható, végtelen készlet áll rendelkezésre, "
			+ "mennyiségük csupán a varázserõ mennyiségén múlik.\n"
			+ "Csapdából is csak egy fajta létezik, és értelemszerûen csak az úton helyezhetõ el."
			+ "Ha egy ellenség rálép, az fogjul ejti, lelassítja a haladását egy kis idõre, így a torony több sebzést tud rajta ejteni."
			+ "A csapda lassítási képessége is javítható egy varázskõvel, ami azt jelenti, hogy tovább tartja fogjul az adott"
			+ "ellenséget.\n"
			+ "A játékot az egeret használva tudjuk irányítani. Ha egy tornyot, akadályt vagy egy varázskövet"
			+ "szeretnénk elhelyezni a pályán, akkor a játékablak ezeknek elkülönített részén a kívánt dologra "
			+ "kattintunk, majd a pálya azon területére, ahová a kiválasztott elemet szeretnénk tenni. A már "
			+ "említett módon torony csak út mellé, azaz mezõre, akadály pedig csak útra építhetõ, míg a különbözõ fajta"
			+ "varázskövek a típusukkal megegyezõ építménnyel kombinálhatók.";
	
	public String getHelp(){
		return help;
	}
}
