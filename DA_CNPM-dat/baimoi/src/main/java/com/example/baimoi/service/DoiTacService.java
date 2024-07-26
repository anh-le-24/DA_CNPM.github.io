package com.example.baimoi.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.baimoi.model.DoiTac;
import com.example.baimoi.model.LoaiNhaHang;
import com.example.baimoi.repository.DoiTacRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class DoiTacService {

    @Autowired
    private DoiTacRepository doiTacRepository;
    @Autowired
    private LoaiNhaHangService loaiNhaHangService;

    @Transactional
    public Optional<DoiTac> getDoiTacById(Long id){
        return doiTacRepository.findById(id);
    }

    public List<DoiTac> getAllDoitac(){
        return doiTacRepository.findAll();
    }
    public void saveDoiTac(DoiTac doiTac) {
        doiTacRepository.save(doiTac);
    }

    public void deleteByIdDT(long id){
        doiTacRepository.deleteById(id);
    }
    
    public List<DoiTac> getDoitacByMadt(Long madt) {
        return doiTacRepository.findByMadt(madt);
    }

    public void saveLoaiNh(LoaiNhaHang loaiNhaHang){
        loaiNhaHangService.save(loaiNhaHang);
    }
    @Transactional
    public DoiTac getDoiTacWithImages(Long id) {
        return doiTacRepository.findDoiTacWithImages(id);
    }
    public DoiTac findByIdDT(Long madt) {
        return doiTacRepository.findById(madt).orElse(null);
    }

    // service tìm kiếm
    public List<DoiTac> searchByName(String tennhahang) {
        return doiTacRepository.findByTennhahangContainingIgnoreCase(tennhahang);
    }

    public List<DoiTac> searchByFullAddress(String address) {
        return doiTacRepository.findBySonhanhContainingIgnoreCaseOrDuongnhContainingIgnoreCaseOrQuannhContainingIgnoreCaseOrThanhphonhContainingIgnoreCase(address, address, address, address);
    }
    
    public List<DoiTac> filterDoiTac(String thanhpho,String hoadon) {
        return doiTacRepository.findByCriteria(thanhpho,hoadon);
    }

    public List<DoiTac> findByLoaiNhaHang(Long loaiNhaHangId) {
        return doiTacRepository.findByLoaiNhaHang(loaiNhaHangId);
    }
    public Long findMaNguoiDungByMaDoiTac(Long madt) {
        return doiTacRepository.findMaNguoiDungByMaDoiTac(madt);
    }
}
