package siat.bestdesign.main.service;

import java.util.List;

import siat.bestdesign.main.domain.MainVO;

public interface MainService {

	List<MainVO> getTopDesigner();

	List<MainVO> getHotDrawing();

	List<MainVO> getDrawing(String saleCate);
}
