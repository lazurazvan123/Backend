# Backend
Backend Applicaton
================BACKEND-APPLICATION=====================
==============Lazu-Ionut-Razvan=========================

	Fisierul de intrare ( cu zonele de vacanta si informati-
ile despre acestea) sunt de forma celor de input.in:
Nume Tara Pret Numar_Activitati activitati data_inceput data_sfarsit


--------------------------Task1-------------------------------------
	Retin aceste informatii intr-un HashMap, deoarece mi s-a 
parut cea mai eficienta metoda pentru a raspunde primului
tip de comanda (Afisarea tuturor informatiilor despre un loc).
Motivul este ca , clientul vrea sa stie toate informatiile despre
un loc introducand doar numele acestui loc. Prin urmare , o "mapare"
intre numele unui loc si obiectul care contine informatiile despre acel 
obiect. De fiecare data cand vreau sa aflu o informatie despre  un loc
functia Hash va calcula indexul obiectului respectiv si il va gasi
in timp constant O(1).

-------------------------------Task2---------------------------------
						    Neterminat 
	In cazul taskului 2,asa cum am inteles enuntul, trebuie sa introduc 
niste date suplimentare. Anume tarile si judetele in care se gasesc 
orasele locurilor respective de vacanta. Desi am creat structurile de date
nu am apucat inca sa implementez dar iata ideea mea: Creez din nou un 
HashMap , de data aceasta de tari. Fiecare tara contine un HashMap de judete
si fiecare Judet contine un Hashmap de orase.Astfel , de fiecare data cand
mi se cere informatii despre o tara, un judet , sau un oras, caut in aceasta
ierarhie . Timpul de cautare nu ar fi mare deoarece, in cazul in care se cere
informatii despre o zona de vacanta dintr-un anumit judet, gasirea Hashmapului
judetului respectiv se face in O(1) din nou. In cazul in care se cer informatii
despre zonele de vacanta dintr-o anumita tara, tara va fi gasita in O(1) ,ceea ce 
nu e neaparat foarte ajutator tinand cont ca tarile ar trebui sa fie oricum putine,
iar informatiile din judete sunt gasite in timp Polinomial.
