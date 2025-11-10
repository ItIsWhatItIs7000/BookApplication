public enum Genre{
    FICTION, NONFICTION, MYSTERY, OTHER, POLITICS, PSYCHOLOGY, RELIGION, ANIME, SCIFI, FANTASY, DRAMA, ROMANCE, SCIENCE;
    public static Genre fromString(String text){
        for (Genre g: Genre.values()){
            if (g.name().equalsIgnoreCase(text)){
                return g;
            }
        }
        return OTHER;
    }
}
