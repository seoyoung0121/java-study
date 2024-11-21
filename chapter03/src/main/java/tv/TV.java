package tv;

public class TV {

	private int channel;
	private int volume;
	private boolean power;

	public TV() {
		this(0, 0, false);
	}

	public TV(int channel, int volume, boolean power) {
		this.channel = channel;
		this.volume = volume;
		this.power = power;
	}

	public void status() {
		System.out.println("TV[channel=" + channel + ", volume=" + volume + ", power=" + (power ? "on" : "off") + "]");
	}

	public int getChannel() {
		return channel;
	}

	public int getVolume() {
		return volume;
	}

	public boolean isPower() {
		return power;
	}

	public void power(boolean on) {
		if (on) {
			power = true;
		} else {
			power = false;
		}
	}

	public void channel(int channel) {
		if (channel > 225) {
			this.channel = 1;
		} else if (channel < 1) {
			this.channel = 225;
		} else {
			this.channel = channel;
		}
	}

	public void channel(boolean up) {
		if (up) {
			this.channel++;
		} else {
			this.channel--;
		}
		if (this.channel > 225) {
			this.channel = 1;
		} else if (this.channel < 1) {
			this.channel = 225;
		}
	}

	public void volume(int volume) {
		if (volume > 100) {
			this.volume = 0;
		} else if (volume < 0) {
			this.volume = 100;
		} else {
			this.volume = volume;
		}
	}

	public void volume(boolean up) {
		if (up) {
			volume++;
		} else {
			volume--;
		}
		if (volume > 100) {
			this.volume = 0;
		} else if (volume < 0) {
			this.volume = 100;
		}

	}
}
