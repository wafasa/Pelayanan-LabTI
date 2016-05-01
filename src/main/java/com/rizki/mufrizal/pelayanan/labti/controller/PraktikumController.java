package com.rizki.mufrizal.pelayanan.labti.controller;

import com.rizki.mufrizal.pelayanan.labti.domain.Praktikum;
import com.rizki.mufrizal.pelayanan.labti.service.PraktikumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @Author Rizki Mufrizal <mufrizalrizki@gmail.com>
 * @Since May 1, 2016
 * @Time 11:02:49 AM
 * @Encoding UTF-8
 * @Project Pelayanan-LabTI
 * @Package com.rizki.mufrizal.pelayanan.labti.controller
 *
 */
@Controller
public class PraktikumController {

    @Autowired
    private PraktikumService praktikumService;

    @RequestMapping(value = "/Praktikum", method = RequestMethod.GET)
    public String ambilPraktikum(Model model) {
        model.addAttribute("praktikums", praktikumService.getPraktikums());
        return "PraktikumView";
    }

    @RequestMapping(value = "/TambahPraktikum", method = RequestMethod.GET)
    public String tambahPraktikum(Model model) {
        model.addAttribute("praktikum", new Praktikum());
        return "PraktikumTambahView";
    }

    @RequestMapping(value = "/SimpanPraktikum", method = RequestMethod.POST)
    public String simpanPraktikum(@ModelAttribute("praktikum") Praktikum praktikum) {
        praktikumService.simpanPraktikum(praktikum);
        return "redirect:/Praktikum";
    }

    @RequestMapping(value = "/EditPraktikum/{idPraktikum}", method = RequestMethod.GET)
    public String editPraktikum(Model model, @PathVariable("idPraktikum") String idPraktikum) {
        model.addAttribute("praktikum", praktikumService.getPraktikum(idPraktikum));
        return "PraktikumEditView";
    }

    @RequestMapping(value = "/UpdatePraktikum", method = RequestMethod.POST)
    public String updatePraktikum(@ModelAttribute("praktikum") Praktikum praktikum) {
        praktikumService.ubahPraktikum(praktikum);
        return "redirect:/Praktikum";
    }

    @RequestMapping(value = "/HapusPraktikum/{idPraktikum}", method = RequestMethod.GET)
    public String hapusPraktikum(@PathVariable("idPraktikum") String idPraktikum) {
        praktikumService.hapusPraktikum(praktikumService.getPraktikum(idPraktikum));
        return "redirect:/Praktikum";
    }

}