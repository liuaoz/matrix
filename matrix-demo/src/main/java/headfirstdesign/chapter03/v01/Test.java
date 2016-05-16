package headfirstdesign.chapter03.v01;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Test {

	public void test() {
	};

	public static void main(String[] args) throws IOException {

		DataOutputStream dos = new DataOutputStream(
				new BufferedOutputStream(new FileOutputStream(new File("e:\\data.txt"))));

		byte d = 3;
		int i = 14;
		char ch = 'c';
		float f = 3.3f;

		dos.writeByte(d);
		dos.writeInt(i);
		dos.writeChar(ch);
		dos.writeFloat(f);

		dos.close();

		DataInputStream dis = new DataInputStream(new BufferedInputStream(new FileInputStream("e:\\data.txt")));

		byte readByte = dis.readByte();
		int readInt = dis.readInt();
		char readChar = dis.readChar();
		float readFloat = dis.readFloat();
		dis.close();
		System.out.println(readInt);
		System.out.println(readByte);
		System.out.println(readFloat);
		System.out.println(readChar);

	}

}
