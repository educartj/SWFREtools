package tv.porst.swfretools.parser.structures;

import static tv.porst.swfretools.parser.SWFParserHelpers.parseBits;
import tv.porst.splib.io.Bits;
import tv.porst.swfretools.parser.SWFBinaryParser;
import tv.porst.swfretools.parser.SWFParserException;

/**
 * Parses a ShapeWithStyle4 structure.
 * 
 * @author sp
 *
 */
public final class ShapeWithStyle4Parser {

	/**
	 * Parses a ShapeWithStyle4 structure.
	 * 
	 * @param parser The parser that parses the structure.
	 * @param fieldName The name of the structure in the parent structure.
	 * 
	 * @return The parsed structure.
	 * 
	 * @throws SWFParserException Thrown if the structure could not be parsed.
	 */
	public static ShapeWithStyle4 parse(final SWFBinaryParser parser, final String fieldName) throws SWFParserException {

		final FillStyle3Array fillStyles = FillStyle3ArrayParser.parse(parser, fieldName + "::FillStyles");
		final LineStyle4Array lineStyles = LineStyle4ArrayParser.parse(parser, fieldName + "::LineStyles");
		final Bits numFillBits = parseBits(parser, 4, 0x00006, fieldName + "::NumFillBits");
		final Bits numLineBits = parseBits(parser, 4, 0x00006, fieldName + "::NumLineBits");
		final ShapeRecord shapeRecord = ShapeRecordParser.parse(parser, numFillBits, numLineBits, fieldName + "::ShapeRecord");

		return new ShapeWithStyle4(fillStyles, lineStyles, numFillBits, numLineBits, shapeRecord);
	}
}