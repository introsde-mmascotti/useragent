package shell;

import healthprofile.storage.service.Measure;

/**
 * Constants for {@link Measure} types.
 *
 */
public enum MeasureTypes {
	
	WEIGHT ("Weight"),
	HEIGHT ("Height"),
	PAL_FACTOR  ("PAL factor");

    private final String type;
    
    MeasureTypes(String type) {
        this.type = type;
    }
    
    public String getType() {
		return type;
	}
}