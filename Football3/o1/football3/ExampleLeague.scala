
////////////////// NOTE TO STUDENTS //////////////////////////
// For the purposes of our course, it’s not necessary
// that you understand or even look at the code in this file.
//////////////////////////////////////////////////////////////

package o1.football3

/** The singleton object `ExampleLeague` provides constants that can be used
  * to experiment with the other classes of this package. More specifically,
  * a bunch of `Club` and `Player` objects are provided.
  *
  * Usage examples (which assume `import ExampleLeague.*` has been given):
  *
  *  - `Player("T. Teekkari", ARS)`
  *
  *  - `Match(LIV, MCI)`
  *
  */
object ExampleLeague:

  val ARS = Club("Arsenal",                 "ARS", "Emirates Stadium")
  val AVL = Club("Aston Villa",             "AVL", "Villa Park")
  val BOU = Club("Bournemouth",             "BOU", "Dean Court")
  val BRE = Club("Brentford",               "BRE", "Gtech Community Stadium")
  val BHA = Club("Brighton & Hove Albion",  "BHA", "Falmer Stadium")
  val BUR = Club("Burnley",                 "BUR", "Turf Moor")
  val CHE = Club("Chelsea",                 "CHE", "Stamford Bridge")
  val CRY = Club("Crystal Palace",          "CRY", "Selhurst Park")
  val EVE = Club("Everton",                 "EVE", "Hill Dickinson Stadium")
  val FUL = Club("Fulham",                  "FUL", "Craven Cottage")
  val LEE = Club("Leeds United",            "LEE", "Elland Road")
  val LIV = Club("Liverpool",               "LIV", "Anfield")
  val MCI = Club("Manchester City",         "MCI", "Etihad Stadium")
  val MUN = Club("Manchester United",       "MUN",  "Old Trafford")
  val NEW = Club("Newcastle United",        "NEW", "St James' Park")
  val NFO = Club("Nottingham Forest",       "NFO", "City Ground")
  val SUN = Club("Sunderland",              "SUN", "Stadium of Light")
  val TOT = Club("Tottenham Hotspur",       "TOT", "Tottenham Hotspur Stadium")
  val WHU = Club("West Ham United",         "WHU", "London Stadium")
  val WOL = Club("Wolverhampton Wanderers", "WOL", "Molineux Stadium")
  val KHI = Club("Kainalniemen Hiki",       "KHI",  "Kainalniemi")

  val Clubs = Seq(ARS, AVL, BOU, BRE, BHA, BUR, CHE, CRY, EVE, FUL, LEE, LIV, MCI, MUN, NEW, NFO, SUN, TOT, WHU, WOL, KHI).sortBy( _.name )

  val Players: Map[Club, Seq[Player]] =
    def teamUp(club: Club, names: String*) =
      club -> names.map( Player(_, club) ).reverse
    Map(teamUp(ARS, "Saka", "Gyökeres", "Ødegaard", "Eze", "Havertz", "Madueke", "Martinelli", "Trossard", "Jesus", "Gabriel", "Saliba", "Merino", "Raya", "Calafiori", "Timber", "Kiwior", "Lewis-Skelly", "White", "Mosquera", "Fábio Vieira", "Nwaneri", "Zubimendi", "Zinchenko", "Nelson", "Arrizabalaga"),
        teamUp(AVL, "Watkins", "Rogers", "Guessand", "Tielemans", "Iling Jr", "McGinn", "Buendía", "Malen", "Martinez", "Barkley", "Dobbin", "Kamara", "Onana", "Bizot", "Cash", "Digne", "Konsa", "Maatsen", "Mings", "Pau", "Broggio"),
        teamUp(BOU, "Semenyo", "Kluivert", "Evanilson", "Tavernier", "Enes Ünal", "Adams", "Brooks", "Christie", "Cook", "Philip", "Scott", "Sinisterra", "Doak", "Petrović", "Senesi", "Smith", "Truffert", "Diakité", "Faivre", "Traorè"),
        teamUp(BRE, "Wissa", "Schade", "Dango", "Damsgaard", "Thiago", "Milambo", "Collins", "Lewis-Potter", "Carvalho", "Henderson", "Janelt", "Jensen", "Nunes", "Onyeka", "Yarmoliuk", "Kelleher", "Ajer", "Henry", "Kayode", "Pinnock", "Roerslev", "Van den Berg"),
        teamUp(BHA, "Mitoma", "Welbeck", "Georginio", "March", "Minteh", "Enciso", "Gruda", "Hinshelwood", "O'Riley", "Sima", "Tzimas", "Ayari", "Baleba", "Buonanotte", "Gomez", "Milner", "Wieffer", "Kostoulas", "Steele", "Verbruggen", "De Cuyper", "Dunk"),
        teamUp(BUR, "Anthony", "Benson", "Bruun Larsen", "Flemming", "Broja", "Boateng", "Churlinov", "Cullen", "Edwards", "Hannibal", "Koleosho", "Laurent", "Tchaouna", "Ugochukwu", "Amdouni", "Foster", "Weiss", "Roberts", "Walker", "Ramsey", "Barnes", "Obafemi", "Dúbravka"),
        teamUp(CHE, "Palmer", "Pedro", "Neto", "Enzo", "Estêvão", "Gittens", "Delap", "Jackson", "Cucurella", "Nkunku", "James", "Caicedo", "Sánchez", "Chalobah", "Colwill", "Gusto", "Hato", "George", "Lavia", "Mudryk", "Jörgensen", "Badiashile", "Fofana"),
        teamUp(CRY, "Mateta", "Sarr", "Muñoz", "Nketiah", "Henderson", "Lacroix", "Mitchell", "Sosa", "Doucouré", "Esse", "Hughes", "Kamada", "Lerma", "Wharton", "Édouard", "Guéhi", "Richards", "Agbinone", "Ahamada", "Devenny"),
        teamUp(EVE, "Ndiaye", "Grealish", "McNeil", "Barry", "Pickford", "Branthwaite", "Tarkowski", "Alcaraz", "Gana", "Beto", "Mykolenko", "O'Brien", "Dewsbury-Hall", "Garner", "Iroegbunam", "Chermiti", "Travers", "Coleman", "Keane", "Patterson", "Aznou", "Armstrong", "King"),
        teamUp(FUL, "Iwobi", "Jiménez", "Smith Rowe", "Adama", "Andreas", "Sessegnon", "Wilson", "Muniz", "Leno", "Robinson", "Berge", "Cairney", "Lukić", "Andersen", "Bassey", "Castagne", "Diop", "Cuenca", "Tete", "King", "Lecomte"),
        teamUp(LEE, "Aaronson", "Gnonto", "Harrison", "James", "Piroe", "Calvert-Lewin", "Ampadu", "Greenwood", "Gruev", "Ramazani", "Tanaka", "Longstaff", "Stach", "Bamford", "Nmecha", "Meslier", "Perri", "Bogle", "Struijk", "Cairns", "Darlow", "Byram", "Gudmundsson", "Rodon"),
        teamUp(LIV, "Salah", "Ekitiké", "Wirtz", "Gakpo", "Chiesa", "Mac Allister", "Szoboszlai", "Frimpong", "Kerkez", "Robertson", "Virgil", "Alisson", "Konaté", "Jones", "Elliott", "Gravenberch", "Bradley", "Gomez", "Tsimikas", "Leoni", "Endo", "Mamardashvili", "Bajcetic"),
        teamUp(MCI, "Haaland", "Marmoush", "Foden", "Savinho", "Bernardo", "Cherki", "Doku", "Gündoğan", "Rodrigo", "Aït-Nouri", "Gvardiol", "Kovačić", "Gonzalez", "Reijnders", "Ederson", "Akanji", "Aké", "Khusanov", "Nunes", "Dias", "Stones", "Bobb", "Echeverri", "Trafford", "Lewis"),
        teamUp(MUN, "Fernandes", "Mbeumo", "Cunha", "Šeško", "Amad", "Garnacho", "Højlund", "Antony", "Mount", "Sancho", "Zirkzee", "Casemiro", "Bayindir", "Onana", "De Ligt", "Martinez", "Mazraoui", "Mainoo", "Ugarte", "Leon", "Dalot", "Dorgu", "Maguire", "Shaw", "Yoro"),
        teamUp(NEW, "Isak", "Gordon", "Elanga", "Barnes", "Bruno", "Murphy", "Joelinton", "Hall", "Schär", "Ramsey", "Tonali", "Osula", "Pope", "Ramsdale", "Botman", "Burn", "Livramento", "Trippier", "Thiaw", "Antoñito", "Willock", "Krafth", "Lascelles"),
        teamUp(NFO, "Wood", "Gibbs-White", "Hudson-Odoi", "Ndoye", "Igor Jesus", "Kalimuendo", "Milenković", "Murillo", "McAtee", "Anderson", "Jota", "Hutchinson", "Awoniyi", "Sels", "Aina", "Williams", "Dominguez", "Sangaré", "Yates"),
        teamUp(SUN, "Adingra", "Diarra", "Roberts", "Isidor", "Mayenda", "Aleksić", "Le Fée", "Mundle", "Neil", "Poveda", "Rigg", "Sadiki", "Talbi", "Xhaka", "Ballard", "Patterson", "Roefs", "Hume", "Ba", "Browne", "Ekwah", "Jones", "Matete", "Triantis", "Marc Guiu"),
        teamUp(TOT, "Solanke", "Johnson", "Maddison", "Kudus", "Kulusevski", "Richarlison", "Tel", "Porro", "Bentancur", "Bergvall", "Bissouma", "Odobert", "Solomon", "Palhinha", "Vicario", "Romero", "Bryan", "Gray", "Sarr", "Danso", "Davies", "Dragusin", "Spence", "Udogie", "Van de Ven"),
        teamUp(WHU, "Bowen", "Paquetá", "Souček", "Ward-Prowse", "Füllkrug", "Wilson", "Summerville", "Álvarez", "Cornet", "Rodriguez", "Guilherme", "Areola", "Hermansen", "Diouf", "Emerson", "Kilman", "Mavropanos", "Aguerd", "Scarles", "Todibo", "Wan-Bissaka", "Walker-Peters"),
        teamUp(WOL, "Strand Larsen", "Hee-Chan", "André", "Bellegarde", "López", "Gomes da Silva", "Munetsi", "Arias", "Silva", "Kalajdžić", "Johnstone", "Sá", "Agbadou", "Doherty", "Bueno", "Mosquera", "R. Gomes", "Bueno", "Toti", "Møller Wolfe", "Tchatchoua", "Chirewa", "Edozie", "Gonzalez"),
        teamUp(KHI, "Elmo"))

end ExampleLeague

