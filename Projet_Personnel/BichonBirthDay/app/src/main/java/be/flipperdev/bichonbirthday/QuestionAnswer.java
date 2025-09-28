package be.flipperdev.bichonbirthday;

public class QuestionAnswer {

    public static String question[] = {
            "Combien de fois avons-nous décoré ma maison pour un gros évènement ?",
            "Qu'est-ce que la couleur \"équateur\" ?",
            "Qu'avais-tu en bouche sur la photo où tu es à l'arrière plan ?" +
                    " (Mme Lutfman te regarde mal.)",
            "À quelle température sont censées être mes toilettes ?"
    };

    public static String choices[][] = {
            {"4", "3", "2"},
            {"du bleu", "du vert", "j'sais pas mais t'as capté"},
            {"une poire", "une pomme", "un biscuit"},
            {"chaude", "froide", "glaciale"}

    };

    public static String correctAnswer[] = {
            "4",
            "j'sais pas mais t'as capté",
            "une pomme",
            "glaciale"
    };

    public static String clues[] = {
            "L'endroit le plus approprié pour la consommer c'est la terrasse normalement... ", //Terrasse - Beuh -- Juan
            "Tu les perds à chaque fois pour les retrouver dans ton sac au final !", //Son sac - Cigarette -- p'tit mots
            "Cherche à l'endroit ou tu es censé mettre ton linge sale !", //Bac à linge sal - T-shirt -- Action + t-shirt blanc zeeman
            "Il est temps de boire un coup, va chercher un truc au frais !" //Frigo -- Bague -- annulaire


    };
    public static String clash[] = {
            "Apprends à compter Zebi !",
            "Je suis attristé que tu ne te souviennes pas de cette fusion entre nos deux neurones...",
            "Ha bah alors... on oublie se qu'on a mis en bouche ?",
            "T'as oublié que c'était le pôle nord dans mes chiottes ?"

    };

}
