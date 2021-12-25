public class Account {

    private final String name;

    public Account(String name) {
        this.name = name;
    }

    public boolean checkNameToEmboss() {

        if (name == null) {
            return false;
        }

        boolean isLengthValid = (name.length() >= 3) && (name.length() <= 19);

        int spaceIndex = name.indexOf(" ");

        boolean isSpacesValid = (spaceIndex != 0) &&
                (spaceIndex != -1) &&
                (spaceIndex != name.length() - 1) &&
                (spaceIndex == name.lastIndexOf(" "));

        return isLengthValid && isSpacesValid;
    }
}
