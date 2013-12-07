javabead13141
=============

Készíts olyan programot, amelyik egy utcát modellez, amelyben házak találhatóak.

A házakhoz (egyedi) házszámok tartoznak. A házak lehetnek lakóházak vagy üzletek. A lakóházakban emberek laknak (legfeljebb megadott számú ember összesen), akiknek számon van tartva a neme, életkora, neve és pénze. A park házaiban gyerekek is laknak (akik egyúttal emberek is), nekik ismertek a szüleik. Az üzletekben emberek dolgoznak, és számon van tartva, hogy mennyi pénz van a kasszában.

A program elindításakor egy parancssori paramétert kap, egy szövegfájl nevét. A fájl tartalmazza az utca házainak adatait, és az emberek adatait a következõképpen.

	lakohaz 1 4
	lakohaz 9 3
	lakohaz 7 1

	ember   Bela  ferfi 40 1 200
	ember   Eva   no    30 1 300
	ember   Janos ferfi 20 7 400

	gyermek Anna  no    10 1 20  Bela Eva

	uzlet 4 400 1 Bela
	uzlet 6 100 2 Eva Janos

Minden egyed adatai egy sorban vannak feltüntetve, illetve a sorok lehetnek üresek is. A sor elsõ szava utal arra, milyen egyeddel van dolgunk, a többi adat ettõl függ. Feltételezhetõ, hogy a fájlban csak helyes adatok találhatóak, a lentebbi kikötésektõl eltekintve.

	lakohaz <házszám> <lakók maximális száma>
	ember   <név> <nem> <életkor> <házszám> <pénz>
	gyermek <név> <nem> <életkor> <házszám> <pénz> <apa> <anya>
	uzlet   <házszám> <kezdeti kassza> <dolgozók száma> <dolgozók nevei>

Az üzleteknek legalább egy dolgozója van, felsõ korlát nincsen.

A program töltse be az utca adatait a fájlból; a dolgozók kezdetben a munkahelyükön vannak, mindenki más otthon. A program írja ki, ha a betöltés során a következõ helytelen adatokat érzékeli:

	- a gyermekek apjának/anyjának nem megfelelõ a neme
	- valakinek negatív összegû a pénze

Ezeket a hibákat csak kijelezni szükséges, megjavítani nem.


Betöltés után a program a sztenderd bemenetrõl várakozzon utasítások feldolgozására. Az utasítások az alábbi formátumúak lehetnek.

	kilep

		A program futása befejezõdik.

	kiir

		Az utca minden adata (amellyel együtt jár minden ember minden adata is) kiíródik a sztenderd kimenetre ízlésesen formázva.

	elment <fájlnév>

		Az utca minden adata elmentõdik a megadott nevû fájlba, a kiir utasításhoz hasonló formátumban.

	atmegy <név> <házszám>

		A megadott nevû ember átmegy a megadott számú házba, ha még befér oda.

	vasarol <név> <összeg>

		A megadott nevû ember vásárolni próbál a megadott összegért. Ennek a következõ feltételei vannak.

		1. Az ember éppen üzletben tartózkodik.
		2. Az üzletben tartózkodik eladó. Ebben az utcában az is feltétele a kiszolgálásnak, hogy az eladó neme megegyezzen a vásárlóéval -- amennyiben nincsen ilyen eladó az üzletben, de behívható, akkor jöjjön be a kiszolgálás megkezdése elõtt.
		3. Gyermekek csak akkor vásárolhatnak, ha valamelyik szülõjük is az üzletben tartózkodik. Ha nincsen vele szülõ, a program hívja be egyiküket.
		4. A vásárlónak rendelkeznie kell a kívánt pénzösszeggel.

		Ha valamilyen okból meghiúsul a vásárlás, a sztenderd kimeneten jelenjen meg a megfelelõ hibaüzenet.
		Különben a vásárlótól vonódjon le a megfelelõ pénzösszeg, a kasszába pedig kerüljön bele.

	fizetes <házszám> <összeg>

		A megadott házszámú üzlet mindegyik dolgozójának átadja a kasszájából a megadott összeget.

		Feltételek: a házszám üzletet takar, amelynek kasszájában megtalálható a kívánt összeg.