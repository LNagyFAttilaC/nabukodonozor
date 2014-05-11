package grafikus;

public class Help {
	private String help = "A j�t�k a Gy�r�k Ura t�m�j�n alapul. T�pus�t tekintve tower defense, strat�giai j�t�k.\n"
			+ "A j�t�k sor�n n�gy fajta, k�l�nb�z� fajb�l sz�rmaz� ellens�gekkel kell felvenni a harcot (t�nd�k, emberek, t�rp�k, hobbitok).\n"
			+ "Ezeknek k�l�nb�z� �rt�k� tulajdons�gaik vannak, de fajonk�nt azonosak.\n"
			+ "A tulajdons�gok megnevez�sei: �leter�, sebess�g, elpuszt�t�sakor szerezhet� var�zser� (az ellens�g �rt�ke). A j�t�k elej�n\n"
			+ "a j�t�kos t�bb p�lya k�z�l v�laszthat. Ezut�n elindul a j�t�k.\n\n"
			+ "A j�t�kos c�lja, hogy megakad�lyozza, hogy a hobbitok, t�nd�k, t�rp�k, emberek eljuttass�k az Egy Gy�r�t a V�gzet Hegy�hez.\n"
			+ "Ennek �rdek�ben tornyokat �p�thet, melyek l�vik a p�ly�n mozg� ellens�geket, ha azok bel�pnek a torony hat�sugar�ba.\n"
			+ "A j�t�kban egy fajta torony �p�thet�, csak �s kiz�r�lag mez�re. A tornyok kezdetben azonos tulajdons�gokkal rendelkeznek.\n"
			+ "Minden torony tulajdons�gait lehet n�velni var�zsk�vekkel. Minden var�zsk� pontosan egy tulajdons�g n�vel�s��rt felel�s.\n"
			+ "Ilyenek az alap sebz�st n�vel� k�vek, az egyes fajokra gyakorolt sebz�st n�vel� k�vek (k�l�n a t�nd�kre, k�l�n az emberekre,\n"
			+ "k�l�n a t�rp�kre �s k�l�n a hobbitokra), a torony t�zel�si frekvenci�j�t n�vel� �s v�g�l a torony hat�t�vols�g�t n�vel� k�vek.\n"
			+ "Egy torony t�bb var�zsk�vet is kaphat, ezek lehetnek k�l�nb�z�ek is. Egy adott var�zsk� vagy csak toronyhoz, vagy csak\n"
			+ "akad�lyhoz haszn�lhat�.\n\n"
			+ "Tornyok �s csapd�k �p�t�s�hez, valamint var�zsk�vek k�sz�t�s�hez a rendelkez�sre �ll� man�t lehet haszn�lni.\n"
			+ "Ez a var�zser� ellens�gek elpuszt�t�s�val n�vekszik, m�g torony, csapda vagy k� elhelyez�sekor cs�kken a dolgok �r�nak\n"
			+ "megfelel�en. Toronyb�l, csapd�b�l, k�b�l b�rmennyi var�zsolhat�, v�gtelen k�szlet �ll rendelkez�sre, mennyis�g�k csup�n a \n"
			+ "var�zser� mennyis�g�n m�lik.\n"
			+ "Csapd�b�l is csak egy fajta l�tezik, �s �rtelemszer�en csak az �ton helyezhet� el. Ha egy ellens�g r�l�p, az fogjul ejti,\n"
			+ "lelass�tja a halad�s�t egy kis id�re, �gy a torony t�bb sebz�st tud rajta ejteni. A csapda lass�t�si k�pess�ge is jav�that�\n"
			+ "egy var�zsk�vel, ami azt jelenti, hogy tov�bb tartja fogjul az adott ellens�get.\n\n"
			+ "A j�t�kot az egeret haszn�lva tudjuk ir�ny�tani. Ha egy tornyot, akad�lyt vagy egy var�zsk�vet szeretn�nk elhelyezni a p�ly�n,\n"
			+ "akkor a j�t�kablak ezeknek elk�l�n�tett r�sz�n a k�v�nt dologra kattintunk, majd a p�lya azon ter�let�re, ahov�\n"
			+ "a kiv�lasztott elemet szeretn�nk tenni. A m�r eml�tett m�don torony csak �t mell�, azaz mez�re, akad�ly pedig csak �tra �p�thet�,\n"
			+ "m�g a k�l�nb�z� fajta var�zsk�vek a t�pusukkal megegyez� �p�tm�nnyel kombin�lhat�k.";
	
	public String getHelp(){
		return help;
	}
}
