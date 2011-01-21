package tv.porst.swfretools.parser.structures;

import tv.porst.splib.io.UINT16;
import tv.porst.splib.io.UINT32;

/**
 * Represents a SoundEnvelope structure.
 * 
 * @author sp
 *
 */
public final class SoundEnvelope {

	/**
	 * Position of envelope point as a number of 44 kHz samples.
	 */
	private final UINT32 pos44;

	/**
	 * Volume level of left channel.
	 */
	private final UINT16 leftLevel;

	/**
	 * Volume level of right channel.
	 */
	private final UINT16 rightLevel;

	/**
	 * Creates a new SoundEnvelope object.
	 * 
	 * @param pos44 Position of envelope point as a number of 44 kHz samples.
	 * @param leftLevel Volume level of left channel.
	 * @param rightLevel Volume level of right channel.
	 */
	public SoundEnvelope(final UINT32 pos44, final UINT16 leftLevel, final UINT16 rightLevel) {

		this.pos44 = pos44;
		this.leftLevel = leftLevel;
		this.rightLevel = rightLevel;

	}

	/**
	 * Returns the volume level of left channel.
	 *
	 * @return The volume level of left channel.
	 */
	public UINT16 getLeftLevel() {
		return leftLevel;
	}

	/**
	 * Returns the position of envelope point as a number of 44 kHz samples.
	 *
	 * @return The position of envelope point as a number of 44 kHz samples.
	 */
	public UINT32 getPos44() {
		return pos44;
	}

	/**
	 * Returns the volume level of right channel.
	 *
	 * @return The volume level of right channel.
	 */
	public UINT16 getRightLevel() {
		return rightLevel;
	}
}