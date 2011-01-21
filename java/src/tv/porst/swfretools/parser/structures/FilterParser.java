package tv.porst.swfretools.parser.structures;

import tv.porst.splib.io.UINT8;
import tv.porst.swfretools.parser.SWFBinaryParser;
import tv.porst.swfretools.parser.SWFParserException;

public class FilterParser {

	public static Filter parse(final SWFBinaryParser parser, final String fieldName) throws SWFParserException {
		final UINT8 filterId = parser.readUInt8();
		final int filterIdValue = filterId.value();

		final DropShadowFilter dropShadowFilter = filterIdValue == 0 ? DropShadowFilterParser.parse(parser, fieldName + "::DropShadowFilter") : null;
		final BlurFilter blurFilter = filterIdValue == 1 ? BlurFilterParser.parse(parser) : null;
		final GlowFilter glowFilter = filterIdValue == 2 ? GlowFilterParser.parse(parser, fieldName + "::GlowFilter") : null;
		final BevelFilter bevelFilter = filterIdValue == 3 ? BevelFilterParser.parse(parser, fieldName + "::BevelFilter") : null;
		final GradientGlowFilter gradientGlowFilter = filterIdValue == 4 ? GradientGlowFilterParser.parse(parser, fieldName + "::GradientGlowFilter") : null;
		final ConvolutionFilter convolutionFilter = filterIdValue == 5 ? ConvolutionFilterParser.parse(parser, fieldName + "::ConvolutionFilter") : null;
		final ColorMatrixFilter colorMatrixFilter = filterIdValue == 6 ? ColorMatrixFilterParser.parse(parser) : null;
		final GradientBevelFilter gradientBevelFilter = filterIdValue == 7 ? GradientBevelFilterParser.parse(parser, fieldName + "::GradientBevelFilter") : null;

		return new Filter(filterId, dropShadowFilter, blurFilter, glowFilter, bevelFilter, gradientGlowFilter, convolutionFilter, colorMatrixFilter, gradientBevelFilter);
	}

}
