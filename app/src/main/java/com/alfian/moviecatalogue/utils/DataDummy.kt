package com.alfian.moviecatalogue.utils

import com.alfian.moviecatalogue.R
import com.alfian.moviecatalogue.data.MovieEntity
import com.alfian.moviecatalogue.data.TvShowEntity
import kotlin.collections.ArrayList

object DataDummy {
    fun generateDummyMovie(): List<MovieEntity> {
        val movie = ArrayList<MovieEntity>()
        movie.add(
            MovieEntity(
                "1",
                "A Star Is Born (2018)",
                "Seasoned musician Jackson Maine discovers — and falls in love with — struggling artist Ally. She has just about given up on her dream to make it big as a singer — until Jack coaxes her into the spotlight. But even as Ally's career takes off, the personal side of their relationship is breaking down, as Jack fights an ongoing battle with his own internal demons.",
                "2h 16m",
                7.5,
                "Drama, Romance, Music",
                R.drawable.poster_a_start_is_born
            )
        )
        movie.add(
            MovieEntity(
                "2",
                "Alita: Battle Angel (2019)",
                "When Alita awakens with no memory of who she is in a future world she does not recognize, she is taken in by Ido, a compassionate doctor who realizes that somewhere in this abandoned cyborg shell is the heart and soul of a young woman with an extraordinary past.",
                "2h 2m",
                7.2,
                "Action, Science Fiction, Adventure",
                R.drawable.poster_alita
            )
        )
        movie.add(
            MovieEntity(
                "3",
                "Aquaman (2018)",
                "Once home to the most advanced civilization on Earth, Atlantis is now an underwater kingdom ruled by the power-hungry King Orm. With a vast army at his disposal, Orm plans to conquer the remaining oceanic people and then the surface world. Standing in his way is Arthur Curry, Orm's half-human, half-Atlantean brother and true heir to the throne.",
                "2h 23m",
                6.9,
                "Action, Adventure, Fantasy",
                R.drawable.poster_aquaman
            )
        )
        movie.add(
            MovieEntity(
                "4",
                "Bohemian Rhapsody (2018)",
                "Singer Freddie Mercury, guitarist Brian May, drummer Roger Taylor and bass guitarist John Deacon take the music world by storm when they form the rock 'n' roll band Queen in 1970. Hit songs become instant classics. When Mercury's increasingly wild lifestyle starts to spiral out of control, Queen soon faces its greatest challenge yet – finding a way to keep the band together amid the success and excess.",
                "2h 15m",
                8.0,
                "Music, Drama, History",
                R.drawable.poster_bohemian
            )
        )
        movie.add(
            MovieEntity(
                "5",
                "Cold Pursuit (2019)",
                "The quiet family life of Nels Coxman, a snowplow driver, is upended after his son's murder. Nels begins a vengeful hunt for Viking, the drug lord he holds responsible for the killing, eliminating Viking's associates one by one. As Nels draws closer to Viking, his actions bring even more unexpected and violent consequences, as he proves that revenge is all in the execution.",
                "1h 59m",
                5.7,
                "Action, Crime, Thriller",
                R.drawable.poster_cold_persuit
            )
        )
        movie.add(
            MovieEntity(
                "6",
                "Creed II (2018)",
                "Between personal obligations and training for his next big fight against an opponent with ties to his family's past, Adonis Creed is up against the challenge of his life",
                "2h 10m",
                6.9,
                "Drama",
                R.drawable.poster_creed
            )
        )
        movie.add(
            MovieEntity(
                "7",
                "Fantastic Beasts: The Crimes of Grindelwald (2018)",
                "Gellert Grindelwald has escaped imprisonment and has begun gathering followers to his cause—elevating wizards above all non-magical beings. The only one capable of putting a stop to him is the wizard he once called his closest friend, Albus Dumbledore. However, Dumbledore will need to seek help from the wizard who had thwarted Grindelwald once before, his former student Newt Scamander, who agrees to help, unaware of the dangers that lie ahead. Lines are drawn as love and loyalty are tested, even among the truest friends and family, in an increasingly divided wizarding world",
                "2h 14m",
                6.9,
                "Adventure, Fantasy, Drama",
                R.drawable.poster_crimes,
            )
        )
        movie.add(
            MovieEntity(
                "8",
                "Glass (2019)",
                "In a series of escalating encounters, former security guard David Dunn uses his supernatural abilities to track Kevin Wendell Crumb, a disturbed man who has twenty-four personalities. Meanwhile, the shadowy presence of Elijah Price emerges as an orchestrator who holds secrets critical to both men.",
                "2h 9m",
                6.7,
                "Thriller, Drama, Science Fiction",
                R.drawable.poster_glass
            )
        )
        movie.add(
            MovieEntity(
                "9",
                "How to Train Your Dragon: The Hidden World (2019)",
                "As Hiccup fulfills his dream of creating a peaceful dragon utopia, Toothless’ discovery of an untamed, elusive mate draws the Night Fury away. When danger mounts at home and Hiccup’s reign as village chief is tested, both dragon and rider must make impossible decisions to save their kind.",
                "1h 44m",
                7.8,
                "Animation, Family, Adventure",
                R.drawable.poster_how_to_train
            )
        )
        movie.add(
            MovieEntity(
                "10",
                "Avengers: Infinity War (2018)",
                "As the Avengers and their allies have continued to protect the world from threats too large for any one hero to handle, a new danger has emerged from the cosmic shadows: Thanos. A despot of intergalactic infamy, his goal is to collect all six Infinity Stones, artifacts of unimaginable power, and use them to inflict his twisted will on all of reality. Everything the Avengers have fought for has led up to this moment - the fate of Earth and existence itself has never been more uncertain.",
                "2h 29m",
                8.3,
                "Adventure, Action, Science Fiction",
                R.drawable.poster_infinity_war
            )
        )
        movie.add(
            MovieEntity(
                "11",
                "Mary Queen of Scots (2018)",
                "In 1561, Mary Stuart, widow of the King of France, returns to Scotland, reclaims her rightful throne and menaces the future of Queen Elizabeth I as ruler of England, because she has a legitimate claim to the English throne. Betrayals, rebellions, conspiracies and their own life choices imperil both Queens. They experience the bitter cost of power, until their tragic fate is finally fulfilled.",
                "2h 4m",
                6.6,
                "Drama, History",
                R.drawable.poster_marry_queen
            )
        )
        movie.add(
            MovieEntity(
                "12",
                "Master Z: Ip Man Legacy (2018)",
                "Following his defeat by Master Ip, Cheung Tin Chi tries to make a life with his young son in Hong Kong, waiting tables at a bar that caters to expats. But it's not long before the mix of foreigners, money, and triad leaders draw him once again to the fight.",
                "1h 47m",
                5.9,
                "Action",
                R.drawable.poster_master_z
            )
        )
        movie.add(
            MovieEntity(
                "13",
                "Mortal Engines (2018)",
                "Many thousands of years in the future, Earth’s cities roam the globe on huge wheels, devouring each other in a struggle for ever diminishing resources. On one of these massive traction cities, the old London, Tom Natsworthy has an unexpected encounter with a mysterious young woman from the wastelands who will change the course of his life forever.",
                "2h 9m",
                6.1,
                "Adventure, Science Fiction",
                R.drawable.poster_mortal_engines
            )
        )
        movie.add(
            MovieEntity(
                "14",
                "Overlord (2018)",
                "France, June 1944. On the eve of D-Day, some American paratroopers fall behind enemy lines after their aircraft crashes while on a mission to destroy a radio tower in a small village near the beaches of Normandy. After reaching their target, the surviving paratroopers realise that, in addition to fighting the Nazi troops that patrol the village, they also must fight against something else.",
                "1h 50m",
                6.7,
                "Horror, War, Science Fiction",
                R.drawable.poster_overlord
            )
        )
        movie.add(
            MovieEntity(
                "15",
                "Ralph Breaks the Internet (2018)",
                "Video game bad guy Ralph and fellow misfit Vanellope von Schweetz must risk it all by traveling to the World Wide Web in search of a replacement part to save Vanellope's video game, Sugar Rush. In way over their heads, Ralph and Vanellope rely on the citizens of the internet — the netizens — to help navigate their way, including an entrepreneur named Yesss, who is the head algorithm and the heart and soul of trend-making site BuzzzTube.",
                "1h 52m",
                7.2,
                "Family, Animation, Comedy, Adventure",
                R.drawable.poster_ralph
            )
        )
        movie.add(
            MovieEntity(
                "16",
                "Robin Hood (2018)",
                "A war-hardened Crusader and his Moorish commander mount an audacious revolt against the corrupt English crown.",
                "1h 56m",
                5.9,
                "Adventure, Action, Thriller",
                R.drawable.poster_robin_hood
            )
        )
        movie.add(
            MovieEntity(
                "17",
                "Serenity (2019)",
                "The quiet life of Baker Dill, a fishing boat captain who lives on the isolated Plymouth Island, where he spends his days obsessed with capturing an elusive tuna while fighting his personal demons, is interrupted when someone from his past comes to him searching for help.",
                "1h 42m",
                5.4,
                "Thriller, Mystery, Drama",
                R.drawable.poster_serenity
            )
        )
        movie.add(
            MovieEntity(
                "18",
                "Spider-Man: Into the Spider-Verse (2018)",
                "Miles Morales is juggling his life between being a high school student and being a spider-man. When Wilson \"Kingpin\" Fisk uses a super collider, others from across the Spider-Verse are transported to this dimension.",
                "1h 57m",
                8.4,
                "Action, Adventure, Animation, Science Fiction, Comedy",
                R.drawable.poster_spiderman
            )
        )
        movie.add(
            MovieEntity(
                "19",
                "T-34 (2018)",
                "In 1944, a courageous group of Russian soldiers managed to escape from German captivity in a half-destroyed legendary T-34 tank. Those were the times of unforgettable bravery, fierce fighting, unbreakable love, and legendary miracles.",
                "2h 19m",
                6.9,
                "War, Action, Drama, History",
                R.drawable.poster_t34
            )
        )
        return movie
    }


    fun generateDummyTvShow(): List<TvShowEntity> {
        val tvShow = ArrayList<TvShowEntity>()

        tvShow.add(
            TvShowEntity(
                "1",
                "Arrow (2012)",
                "Spoiled billionaire playboy Oliver Queen is missing and presumed dead when his yacht is lost at sea. He returns five years later a changed man, determined to clean up the city as a hooded vigilante armed with a bow.",
                "42m",
                6.6,
                "Crime, Drama, Mystery, Action & Adventure",
                R.drawable.zposter_arrow
            )
        )
        tvShow.add(
            TvShowEntity(
                "2",
                "Doom Patrol (2019)",
                "The Doom Patrol’s members each suffered horrible accidents that gave them superhuman abilities — but also left them scarred and disfigured. Traumatized and downtrodden, the team found purpose through The Chief, who brought them together to investigate the weirdest phenomena in existence — and to protect Earth from what they find.",
                "49m",
                7.6,
                "Sci-Fi & Fantasy, Comedy, Drama",
                R.drawable.zposter_doom_patrol
            )
        )
        tvShow.add(
            TvShowEntity(
                "3",
                "Dragon Ball (1986)",
                "Long ago in the mountains, a fighting master known as Gohan discovered a strange boy whom he named Goku. Gohan raised him and trained Goku in martial arts until he died. The young and very strong boy was on his own, but easily managed. Then one day, Goku met a teenage girl named Bulma, whose search for the mystical Dragon Balls brought her to Goku's home. Together, they set off to find all seven and to grant her wish.",
                "25m",
                8.1,
                "Animation, Action & Adventure, Sci-Fi & Fantasy",
                R.drawable.zposter_dragon_ball
            )
        )
        tvShow.add(
            TvShowEntity(
                "4",
                "Fairy Tail (2009)",
                "Lucy is a 17-year-old girl, who wants to be a full-fledged mage. One day when visiting Harujion Town, she meets Natsu, a young man who gets sick easily by any type of transportation. But Natsu isn't just any ordinary kid, he's a member of one of the world's most infamous mage guilds: Fairy Tail.",
                "25m",
                7.8,
                "Action & Adventure, Animation, Comedy, Sci-Fi & Fantasy",
                R.drawable.zposter_fairytail
            )
        )
        tvShow.add(
            TvShowEntity(
                "5",
                "Family Guy (1999)",
                "Sick, twisted, politically incorrect and Freakin' Sweet animated series featuring the adventures of the dysfunctional Griffin family. Bumbling Peter and long-suffering Lois have three kids. Stewie (a brilliant but sadistic baby bent on killing his mother and taking over the world), Meg (the oldest, and is the most unpopular girl in town) and Chris (the middle kid, he's not very bright but has a passion for movies). The final member of the family is Brian - a talking dog and much more than a pet, he keeps Stewie in check whilst sipping Martinis and sorting through his own life issues.",
                "22m",
                7.0,
                "Animation, Comedy",
                R.drawable.zposter_family_guy
            )
        )
        tvShow.add(
            TvShowEntity(
                "6",
                "The Flash (2014)",
                "After a particle accelerator causes a freak storm, CSI Investigator Barry Allen is struck by lightning and falls into a coma. Months later he awakens with the power of super speed, granting him the ability to move through Central City like an unseen guardian angel. Though initially excited by his newfound powers, Barry is shocked to discover he is not the only \"meta-human\" who was created in the wake of the accelerator explosion -- and not everyone is using their new powers for good. Barry partners with S.T.A.R. Labs and dedicates his life to protect the innocent. For now, only a few close friends and associates know that Barry is literally the fastest man alive, but it won't be long before the world learns what Barry Allen has become...The Flash.",
                "44m",
                7.7,
                "Drama, Sci-Fi & Fantasy",
                R.drawable.zposter_flash
            )
        )
        tvShow.add(
            TvShowEntity(
                "7",
                "Gotham (2014)",
                "Everyone knows the name Commissioner Gordon. He is one of the crime world's greatest foes, a man whose reputation is synonymous with law and order. But what is known of Gordon's story and his rise from rookie detective to Police Commissioner? What did it take to navigate the multiple layers of corruption that secretly ruled Gotham City, the spawning ground of the world's most iconic villains? And what circumstances created them – the larger-than-life personas who would become Catwoman, The Penguin, The Riddler, Two-Face and The Joker?",
                "43m",
                7.5,
                "Drama, Crime, Sci-Fi & Fantasy",
                R.drawable.zposter_gotham
            )
        )
        tvShow.add(
            TvShowEntity(
                "8",
                "Grey's Anatomy (2005)",
                "Follows the personal and professional lives of a group of doctors at Seattle’s Grey Sloan Memorial Hospital.",
                "43m",
                8.2,
                "Drama",
                R.drawable.zposter_grey_anatomy
            )
        )
        tvShow.add(
            TvShowEntity(
                "9",
                "Hanna (2019)",
                "This thriller and coming-of-age drama follows the journey of an extraordinary young girl as she evades the relentless pursuit of an off-book CIA agent and tries to unearth the truth behind who she is. Based on the 2011 Joe Wright film.",
                "43m",
                8.2,
                "Drama",
                R.drawable.zposter_hanna
            )
        )
        tvShow.add(
            TvShowEntity(
                "10",
                "Marvel's Iron Fist (2017)",
                "Danny Rand resurfaces 15 years after being presumed dead. Now, with the power of the Iron Fist, he seeks to reclaim his past and fulfill his destiny.",
                "55m",
                6.6,
                "Action & Adventure, Drama, Sci-Fi & Fantasy",
                R.drawable.zposter_iron_fist
            )
        )
        tvShow.add(
            TvShowEntity(
                "11",
                "Naruto Shippūden (2007)",
                "Naruto Shippuuden is the continuation of the original animated TV series Naruto.The story revolves around an older and slightly more matured Uzumaki Naruto and his quest to save his friend Uchiha Sasuke from the grips of the snake-like Shinobi, Orochimaru. After 2 and a half years Naruto finally returns to his village of Konoha, and sets about putting his ambitions to work, though it will not be easy, as He has amassed a few (more dangerous) enemies, in the likes of the shinobi organization; Akatsuki.",
                "25m",
                8.6,
                "Animation, Action & Adventure, Sci-Fi & Fantasy",
                R.drawable.zposter_naruto_shipudden
            )
        )
        tvShow.add(
            TvShowEntity(
                "12",
                "NCIS (2003)",
                "From murder and espionage to terrorism and stolen submarines, a team of special agents investigates any crime that has a shred of evidence connected to Navy and Marine Corps personnel, regardless of rank or position.",
                "45m",
                7.4,
                "Crime, Action & Adventure, Drama",
                R.drawable.zposter_ncis
            )
        )
        tvShow.add(
            TvShowEntity(
                "13",
                "Riverdale (2017)",
                "Set in the present, the series offers a bold, subversive take on Archie, Betty, Veronica and their friends, exploring the surreality of small-town life, the darkness and weirdness bubbling beneath Riverdale’s wholesome facade.",
                "45m",
                8.6,
                "Mystery, Drama, Crime",
                R.drawable.zposter_riverdale
            )
        )
        tvShow.add(
            TvShowEntity(
                "14",
                "Shameless (2011)",
                "Chicagoan Frank Gallagher is the proud single dad of six smart, industrious, independent kids, who without him would be... perhaps better off. When Frank's not at the bar spending what little money they have, he's passed out on the floor. But the kids have found ways to grow up in spite of him. They may not be like any family you know, but they make no apologies for being exactly who they are.",
                "57m",
                8.0,
                "Drama, Comedy",
                R.drawable.zposter_shameless
            )
        )
        tvShow.add(
            TvShowEntity(
                "15",
                "Supergirl (2015)",
                "Twenty-four-year-old Kara Zor-El, who was taken in by the Danvers family when she was 13 after being sent away from Krypton, must learn to embrace her powers after previously hiding them. The Danvers teach her to be careful with her powers, until she has to reveal them during an unexpected disaster, setting her on her journey of heroism.",
                "42m",
                7.2,
                "Drama, Sci-Fi & Fantasy, Action & Adventure",
                R.drawable.zposter_supergirl
            )
        )

        return tvShow
    }

}