package org.dispatcher.web.controller;

import java.util.List;

import javax.inject.Inject;

import org.dispatcher.core.service.ConsigmentService;
import org.dispatcher.core.service.DispatcherService;
import org.dispatcher.persistence.domain.Consignment;
import org.dispatcher.service.util.DispatchPeriod;
import org.dispatcher.service.util.DispatchPeriod.Period;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 * I tried to implement spring'ew new model as suggested by Martin Flowr. But
 * due to time limitations I left the implementation of the DTO.
 * 
 * @author amirtharaj.v
 *
 */
@Controller
public class DispatcherController {

	@Inject
	private ConsigmentService consigmentProvider;

	@Inject
	private DispatcherService dispatcherService;

	@RequestMapping(value = "/startNewBatch")
	private ModelAndView startNewBatch() {

		ModelAndView modelAndView = new ModelAndView();
		DispatchPeriod period = new DispatchPeriod();
		period.setDipatchPeriod(Period.TODAY);

		List<Consignment> consigments = consigmentProvider.getConsignmentsByDispatchPeriod(period);
		modelAndView.setViewName("consigments");

		if (consigments == null || consigments.isEmpty()) {
			// TODO for no records
		} else {
			modelAndView.addObject("consigments", consigments);
		}

		return modelAndView;
	}

	/**
	 * I assume we get the consignments from db back or we can get the
	 * consignments from db as well.
	 * 
	 * @param consigments
	 * @return
	 */
	@RequestMapping(value = "/addConsignments")
	private ModelAndView addConsignments(@RequestParam("foo") List<Consignment> consigments) {
		ModelAndView modelAndView = new ModelAndView("dispatch");
		dispatcherService.dispatch(consigments);
		return modelAndView;
		// TODO add appropriate message to ui
	}

	/**
	 * I assume get the {@link Consignment} from ui. If we want to avoid
	 * traveling the list to and pro we can get those from db
	 * 
	 * @param consigments
	 * @return
	 */
	@RequestMapping(value = "/endDispatch")
	private ModelAndView endDispatch(@RequestParam("foo") List<Consignment> consigments) {
		ModelAndView modelAndView = new ModelAndView("endDispatch");
		dispatcherService.endDispatch(consigments);
		return modelAndView;
		// TODO add appropriate message to ui
	}
}
