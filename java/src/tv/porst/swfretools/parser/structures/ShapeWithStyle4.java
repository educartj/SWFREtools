package tv.porst.swfretools.parser.structures;

import tv.porst.splib.io.Bits;

/**
 * Represents a ShapeWithStyle4 structure.
 * 
 * @author sp
 *
 */
public final class ShapeWithStyle4 {

	/**
	 * Array of fill styles.
	 */
	private final FillStyle3Array fillStyles;

	/**
	 * Array of line styles.
	 */
	private final LineStyle4Array lineStyles;

	/**
	 * Number of fill index bits.
	 */
	private final Bits numFillBits;

	/**
	 * Number of line index bits.
	 */
	private final Bits numLineBits;

	/**
	 * Shape records.
	 */
	private final ShapeRecord shapeRecord;

	/**
	 * Creates a new ShapeWithStyle object.
	 * 
	 * @param fillStyles Array of fill styles.
	 * @param lineStyles Array of line styles.
	 * @param numFillBits Number of fill index bits.
	 * @param numLineBits Number of line index bits.
	 * @param shapeRecord Shape records.
	 */
	public ShapeWithStyle4(final FillStyle3Array fillStyles, final LineStyle4Array lineStyles,
			final Bits numFillBits, final Bits numLineBits, final ShapeRecord shapeRecord) {

		this.fillStyles = fillStyles;
		this.lineStyles = lineStyles;
		this.numFillBits = numFillBits;
		this.numLineBits = numLineBits;
		this.shapeRecord = shapeRecord;

	}

	/**
	 * Returns the array of fill styles.
	 *
	 * @return The array of fill styles.
	 */
	public FillStyle3Array getFillStyles() {
		return fillStyles;
	}

	/**
	 * Returns the array of line styles.
	 *
	 * @return The array of line styles.
	 */
	public LineStyle4Array getLineStyles() {
		return lineStyles;
	}

	/**
	 * Returns the number of fill index bits.
	 *
	 * @return The number of fill index bits.
	 */
	public Bits getNumFillBits() {
		return numFillBits;
	}

	/**
	 * Returns the number of line index bits.
	 *
	 * @return The number of line index bits.
	 */
	public Bits getNumLineBits() {
		return numLineBits;
	}

	/**
	 * Returns the shape records.
	 *
	 * @return The shape records.
	 */
	public ShapeRecord getShapeRecord() {
		return shapeRecord;
	}
}