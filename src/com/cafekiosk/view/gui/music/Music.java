package com.cafekiosk.view.gui.music;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;
//�����带 ���� ������ �����Ű�� ���� Ŭ����
public class Music extends Thread {
	private Player player;
	private boolean isLoop;
	private File file;
	private FileInputStream fis;
	private BufferedInputStream bis;

	
	public Music(String name, boolean isLoop) {
		this.isLoop=isLoop;
		try{
			file=new File("./data/music/"+name);
			fis=new FileInputStream(file);
			bis=new BufferedInputStream(fis);
			player= new Player(bis);
		}catch(JavaLayerException e) {
		}catch(IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		super.run();
		try {
			do {
				player.play();
				fis=new FileInputStream(file);
				bis=new BufferedInputStream(fis);
				player= new Player(bis);
			} while (isLoop);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
