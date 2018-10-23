package avaj.simulator;

class ParsedItem {
    
    private String  type;
    private String  name;
    private int     longitude;
    private int     latitude;
    private int     height;

    ParsedItem(
        String sType,
        String sName,
        String sLongitude,
        String sLatitude,
        String sHeight
    ) {
        type        = new String(sType);
        name        = new String(sName);
        longitude   = Integer.parseInt(sLongitude);
        latitude    = Integer.parseInt(sLatitude);
        height      = Integer.parseInt(sHeight);
    }

    String getType() {
        return (type);
    }

    String getName() {
        return (name);
    }

    int getLongitude() {
        return (longitude);
    }

    int getLatitude() {
        return (latitude);
    }

    int getHeight () {
        return (height);
    }

}