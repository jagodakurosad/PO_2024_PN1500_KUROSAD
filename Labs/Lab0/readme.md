# Lab 0: Git - rozproszony system kontroli wersji

W tym ćwiczeniu zapoznamy się z systemem **Git**, jednym z najbardziej popularnych systemów do wersjonowania kodu źródłowego
oraz hostingiem do projektów **GitHub**. Git będzie nam towarzyszyć przez cały semestr (a także i pewnie poza zajęciami), dlatego warto poświęcić mu odpowiednio dużo uwagi.

## Wstęp

Git jest rozproszonym systemem wersjonowania pracy. Jego najważniejsze cechy to:

* możliwość zapisywania stanu kodu źródłowego w określonym momencie
* możliwość przywracania starych wersji kodu źródłowego
* możliwość pracy w gałęziach ("branchach")
* brak centralnego repozytorium kodu (repozytorium rozproszone), co pozwala na lokalne wersjonowanie kodu bez wysyłania go na serwer

## Zadania do wykonania

Do wykonania wszystkich ćwiczeń na tym laboratorium potrzebne będą **jedynie zainstalowany Git oraz terminal**. Jeśli nie jesteś fanem pracy z samą konsolą warto zaopatrzyć się też w aplikację z GUI do obsługi Git:

- [GitKraken](https://www.gitkraken.com) - najbardziej zaawansowane narzędzie tego typu, wersja Pro jest darmowa dla studentów korzystających z [GitHub Student Developer Pack](https://education.github.com/pack) (bardzo polecam go sobie aktywować niezależnie od samego Gita!)
- [SourceTree](https://www.sourcetreeapp.com) - popularny darmowy klient z podstawowymi funkcjami i wizualizacją repozytorium.

W trakcie semestru będziemy korzystać ze środowiska IntelliJ do tworzenia projektów w Javie. IntelliJ również umożliwia pracę z Gitem, można więc całkowicie zrezygnować z dodatkowych programów. Nie zalecamy jednak tego podejścia, szczególnie na początku przygody z Gitem, ponieważ IntelliJ opakowuje i ukrywa wiele operacji Gita i łatwo stracić nad tym kontrolę. Najlepszym wyborem na program towarzyszący nauce Gita wydaje się obecnie GitKraken. 

### Ćwiczenia Git

1. Otwórz stronę https://gitexercises.fracz.com 
2. Postępuj zgodnie z instrukcjami na stronie i zrealizuj **pierwsze 8 ćwiczeń z zestawu** (do *change-branch-history* włącznie).

### Przygotowanie własnego repozytorium

1. Zarejestruj się na GitHubie.

2. Stwórz nowe repozytorium i nazwij je odpowiednio (schemat nazywania poniżej) - będziesz w nim przechowywać rozwiązania zadań z kolejnych laboratoriów.

   * nazwa repozytorium to PO_2024_[dzień][godzina]_[nazwisko studenta] - np. PO_2024_PN1500_BRZECZYSZCZYKIEWICZ lub PO_2024_WT1820_PAPADOPOULOS. Dzień prosimy zapisać w formacie dwuliterowym bez polskich znaków (PN, WT, SR, CZ, PT),
   * repozytorium może być prywatne lub publiczne. Na potrzeby naszych zajęć repozytoria powinny być **prywatne**,
   * możesz na tym etapie zaznaczyć opcję *Add a README file* - zainicjujesz w ten sposób repozytorium plikiem, którego zawartość będzie domyślna na głównej stronie repozytorium.

3. Nadaj uprawnienia dostępu do repozytorium prowadzącemu zajęcia (*Settings --> Collaborators --> Add people*).

4. Sklonuj repozytorium na lokalny komputer.

5. Utwórz *branch* o nazwie **lab0** i przełącz się na niego.

6. Zmodyfikuj plik README.MD, dodając do niego następujące informacje:

   1. Imię i nazwisko

   2. Grupę i godzinę zajęć

   3. Nazwę swojego zwierzaka

   4. Link do swojego profilu na https://gitexercises.fracz.com

   5. Możesz też dodać dowolny dodatkowy tekst, to Twoje repo. ;)

   **Uwaga**: zanim zapiszesz nazwę swojego zwierzaka, [upewnij się czy nie jest ona już zajęta](https://aghedupl-my.sharepoint.com/:x:/g/personal/miidzik_agh_edu_pl/EbRk-hL6hWJKnESfA3NMlVEBJi-fSMmz-Z9pIOwQ7tpdkg?e=GwTsDz), żeby uniknąć kolizji z innymi studentami! Każdy zwierzak powinien być unikalny. Podlinkowany arkusz aktualizuje się automatycznie co jakiś czas.

7. Dodaj plik **.gitignore** i przygotuj go do pracy ze środowiskiem IntelliJ - możesz skorzystać z [gotowego szablonu](https://github.com/github/gitignore/blob/main/Global/JetBrains.gitignore).

8. Zrób *commit* i *push* swoich zmian na zdalny branch o tej samej nazwie (*origin/lab0*).

9. Na stronie swojego repozytorium na GitHubie przejdź do sekcji *Pull requests*. Utwórz nowy Pull Request **lab0 --> main**. Możesz go nazwać np. "Lab0 do oceny". 

   W ten sposób prowadzący będzie mógł zobaczyć i ocenić Twoje zmiany (np. dodać komentarze w PR). Po sprawdzeniu i ocenieniu Lab PR-a należy scalić z główną gałęzią (przycisk ***Merge pull request*** w widoku PR). 

   **Podobną procedurę będziemy stosować na wszystkich kolejnych laboratoriach. Pamiętaj by zawsze na początku pracy tworzyć branch z głównej gałęzi, commitować zmiany (liczba commitów nie ma znaczenia), a na koniec przygotować PR do sprawdzenia. Więcej informacji na ten temat znajdziesz w dodatkowej instrukcji:**
   
   [Praca z Git na kolejnych laboratoriach](git_workflow_tutorial.md)
   
10. Po wykonaniu wszystkich ćwiczeń [zarejestruj swojego zwierzaka wypełniając formularz](https://forms.office.com/Pages/ResponsePage.aspx?id=PwOxgOAhgkq7wPBf3M07yF6m9cn7cIlCm9fFlCH8KDJUMzdIU0NaTzUyTkFLME5TUzBCVFJRUDVJUi4u). W ten sposób prowadzący będzie wiedział również, jak dostać się do Twojego repozytorium.
   

## Przydatne informacje

### Polecenia do wykonania za pierwszym razem (jeśli projekt nie jest w żadnym repozytorium)

W celu przygotowania kodu źródłowego do pracy z Gitem należy, będąc w głównym katalogu naszej aplikacji, wykonać następujące polecenia

1. `git init` (zainicjowanie plików Gita: w głównym katalogu naszej aplikacji, tworzony jest katalog `.git`, który
   zawiera repozytorium kodu źródłowego)
   
2. `echo 'out' > .gitignore` (dodanie katalogu `out` do listy ingorowanych plików/katalogów)

   **Uwaga:** Powyższe polecenie w PowerShellu powoduje problemy. W tej sytuacji zalecane jest po prostu utworzenie pliku
   `.gitignore` w edytorze tekstu i wpisanie do niego linii o treści `out`.

3. `git add .` (dodanie wszystkich plików, poza ignorowanymi, do *indeksu* Gita)

4. `git status` (sprawdzenie aktualnego statusu kodu źródłowego, polecenie wykonywane bardzo często)

5. `git commit -m 'Initial commit'` (*zatwierdzenie* (zacommitowanie) zmian w historii Gita)

6. `git remote add origin https://github.com/<login>/<repozytorium>.git` (dodanie zdalnego repozytorium z Githuba)

9. `git push origin master` (wysłanie zmian do zdalnego repozytorium)

### Odtworzenie repozytorium

1. `git clone https://github.com/<login>/<repozytorium>.git` - *sklonowanie* zdalnego repozytorium

Alternatywnie

1. IntelliJ -> Import from Git

W poniższych poleceniach fragment ujęty w nawiasy ostre, np. `<file-name>`, należy zastąpić **innym** łańcuchem znaków.

### Zatwierdzenie zmian na koniec pracy

1. `git add <file-name>` (dodanie zmian w pliku `<file-name>` do *indeksu* - operację powtórzyć dla każdego modyfikowanego i nowego pliku, lub użyć wyrażenia typu `git add *.java`)
2. `git commit -m '<Meaningful description of change>'` (*zatwierdzenie* zmian znajdujących się w indeksie)
3. `git push origin <branch-name>` (wysłanie zmian do zdalnego repozytorium na gałąź `<branch-name>`; jeśli tworzymy nowy branch może być konieczne dodanie przełącznika `--set-upstream-to`)


### Aktualizowanie się względem zdalnej gałęzi `master`

1. `git remote add <remote-repo-name> <remote-repo-address>` (dodanie zdalnego repozytorium; jeśli korzystamy z jednego zdalnego repozytorium, to zwyczajowo ma ono nazwę `origin`).
2. `git checkout master` (przełączenie się do lokalnej gałęzi master).
3. `git pull <remote-repo-name> master` (pobranie do lokalnej gałęzi `master` zmian ze zdalnej gałęzi `master`)
4. `git checkout <feature-branch>` (przełączenie się do gałęzi, na której pracowaliśmy).
5. `git rebase master` (przepięcie commitów z obecnej gałęzi tak, by poprzedzał je ostatni commit z `master`).
6. Rozwiązanie konfliktów, ewentualne wprowadzenie zmian.
7. `git push origin <feature-branch> -f` (wysłanie zaktualizowanej wersji do zdalnej gałęzi `<feature-branch>` w naszym
   repozytorium).


## Przydatne odnośniki

* https://git-scm.com/book/pl/v2 - oficjalny podręcznik Gita, częściowo przetłumaczony na język polski
* https://guides.github.com/introduction/git-handbook/ - wprowadzenie do Gita, wyjaśnienie najważniejszych koncepcji
* https://www.atlassian.com/git/tutorials/learn-git-with-bitbucket-cloud - inne wprowadzenie do Gita, zawiera dużo
  ilustracji
