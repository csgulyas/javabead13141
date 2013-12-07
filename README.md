javabead13141
=============

K�sz�ts olyan programot, amelyik egy utc�t modellez, amelyben h�zak tal�lhat�ak.

A h�zakhoz (egyedi) h�zsz�mok tartoznak. A h�zak lehetnek lak�h�zak vagy �zletek. A lak�h�zakban emberek laknak (legfeljebb megadott sz�m� ember �sszesen), akiknek sz�mon van tartva a neme, �letkora, neve �s p�nze. A park h�zaiban gyerekek is laknak (akik egy�ttal emberek is), nekik ismertek a sz�leik. Az �zletekben emberek dolgoznak, �s sz�mon van tartva, hogy mennyi p�nz van a kassz�ban.

A program elind�t�sakor egy parancssori param�tert kap, egy sz�vegf�jl nev�t. A f�jl tartalmazza az utca h�zainak adatait, �s az emberek adatait a k�vetkez�k�ppen.

	lakohaz 1 4
	lakohaz 9 3
	lakohaz 7 1

	ember   Bela  ferfi 40 1 200
	ember   Eva   no    30 1 300
	ember   Janos ferfi 20 7 400

	gyermek Anna  no    10 1 20  Bela Eva

	uzlet 4 400 1 Bela
	uzlet 6 100 2 Eva Janos

Minden egyed adatai egy sorban vannak felt�ntetve, illetve a sorok lehetnek �resek is. A sor els� szava utal arra, milyen egyeddel van dolgunk, a t�bbi adat ett�l f�gg. Felt�telezhet�, hogy a f�jlban csak helyes adatok tal�lhat�ak, a lentebbi kik�t�sekt�l eltekintve.

	lakohaz <h�zsz�m> <lak�k maxim�lis sz�ma>
	ember   <n�v> <nem> <�letkor> <h�zsz�m> <p�nz>
	gyermek <n�v> <nem> <�letkor> <h�zsz�m> <p�nz> <apa> <anya>
	uzlet   <h�zsz�m> <kezdeti kassza> <dolgoz�k sz�ma> <dolgoz�k nevei>

Az �zleteknek legal�bb egy dolgoz�ja van, fels� korl�t nincsen.

A program t�ltse be az utca adatait a f�jlb�l; a dolgoz�k kezdetben a munkahely�k�n vannak, mindenki m�s otthon. A program �rja ki, ha a bet�lt�s sor�n a k�vetkez� helytelen adatokat �rz�keli:

	- a gyermekek apj�nak/anyj�nak nem megfelel� a neme
	- valakinek negat�v �sszeg� a p�nze

Ezeket a hib�kat csak kijelezni sz�ks�ges, megjav�tani nem.


Bet�lt�s ut�n a program a sztenderd bemenetr�l v�rakozzon utas�t�sok feldolgoz�s�ra. Az utas�t�sok az al�bbi form�tum�ak lehetnek.

	kilep

		A program fut�sa befejez�dik.

	kiir

		Az utca minden adata (amellyel egy�tt j�r minden ember minden adata is) ki�r�dik a sztenderd kimenetre �zl�sesen form�zva.

	elment <f�jln�v>

		Az utca minden adata elment�dik a megadott nev� f�jlba, a kiir utas�t�shoz hasonl� form�tumban.

	atmegy <n�v> <h�zsz�m>

		A megadott nev� ember �tmegy a megadott sz�m� h�zba, ha m�g bef�r oda.

	vasarol <n�v> <�sszeg>

		A megadott nev� ember v�s�rolni pr�b�l a megadott �sszeg�rt. Ennek a k�vetkez� felt�telei vannak.

		1. Az ember �ppen �zletben tart�zkodik.
		2. Az �zletben tart�zkodik elad�. Ebben az utc�ban az is felt�tele a kiszolg�l�snak, hogy az elad� neme megegyezzen a v�s�rl��val -- amennyiben nincsen ilyen elad� az �zletben, de beh�vhat�, akkor j�jj�n be a kiszolg�l�s megkezd�se el�tt.
		3. Gyermekek csak akkor v�s�rolhatnak, ha valamelyik sz�l�j�k is az �zletben tart�zkodik. Ha nincsen vele sz�l�, a program h�vja be egyik�ket.
		4. A v�s�rl�nak rendelkeznie kell a k�v�nt p�nz�sszeggel.

		Ha valamilyen okb�l meghi�sul a v�s�rl�s, a sztenderd kimeneten jelenjen meg a megfelel� hiba�zenet.
		K�l�nben a v�s�rl�t�l von�djon le a megfelel� p�nz�sszeg, a kassz�ba pedig ker�lj�n bele.

	fizetes <h�zsz�m> <�sszeg>

		A megadott h�zsz�m� �zlet mindegyik dolgoz�j�nak �tadja a kassz�j�b�l a megadott �sszeget.

		Felt�telek: a h�zsz�m �zletet takar, amelynek kassz�j�ban megtal�lhat� a k�v�nt �sszeg.