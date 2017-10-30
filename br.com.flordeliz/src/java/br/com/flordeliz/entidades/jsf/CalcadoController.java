package br.com.flordeliz.entidades.jsf;

import br.com.flordeliz.entidades.Calcado;
import br.com.flordeliz.entidades.jsf.util.JsfUtil;
import br.com.flordeliz.entidades.jsf.util.JsfUtil.PersistAction;
import br.com.flordeliz.entidades.bean.CalcadoFacade;

import java.io.Serializable;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.ejb.EJBException;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

@Named("calcadoController")
@SessionScoped
public class CalcadoController implements Serializable {

    @EJB
    private br.com.flordeliz.entidades.bean.CalcadoFacade ejbFacade;
    private List<Calcado> items = null;
    private Calcado selected;

    public CalcadoController() {
    }

    public Calcado getSelected() {
        return selected;
    }

    public void setSelected(Calcado selected) {
        this.selected = selected;
    }

    protected void setEmbeddableKeys() {
    }

    protected void initializeEmbeddableKey() {
    }

    private CalcadoFacade getFacade() {
        return ejbFacade;
    }

    public Calcado prepareCreate() {
        selected = new Calcado();
        initializeEmbeddableKey();
        return selected;
    }

    public void create() {
        persist(PersistAction.CREATE, ResourceBundle.getBundle("/resource/Bundle").getString("CalcadoCreated"));
        if (!JsfUtil.isValidationFailed()) {
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public void update() {
        persist(PersistAction.UPDATE, ResourceBundle.getBundle("/resource/Bundle").getString("CalcadoUpdated"));
    }

    public void destroy() {
        persist(PersistAction.DELETE, ResourceBundle.getBundle("/resource/Bundle").getString("CalcadoDeleted"));
        if (!JsfUtil.isValidationFailed()) {
            selected = null; // Remove selection
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public List<Calcado> getItems() {
        if (items == null) {
            items = getFacade().findAll();
        }
        return items;
    }

    private void persist(PersistAction persistAction, String successMessage) {
        if (selected != null) {
            setEmbeddableKeys();
            try {
                if (persistAction != PersistAction.DELETE) {
                    getFacade().edit(selected);
                } else {
                    getFacade().remove(selected);
                }
                JsfUtil.addSuccessMessage(successMessage);
            } catch (EJBException ex) {
                String msg = "";
                Throwable cause = ex.getCause();
                if (cause != null) {
                    msg = cause.getLocalizedMessage();
                }
                if (msg.length() > 0) {
                    JsfUtil.addErrorMessage(msg);
                } else {
                    JsfUtil.addErrorMessage(ex, ResourceBundle.getBundle("/resource/Bundle").getString("PersistenceErrorOccured"));
                }
            } catch (Exception ex) {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, ex);
                JsfUtil.addErrorMessage(ex, ResourceBundle.getBundle("/resource/Bundle").getString("PersistenceErrorOccured"));
            }
        }
    }

    public Calcado getCalcado(java.lang.Integer id) {
        return getFacade().find(id);
    }

    public List<Calcado> getItemsAvailableSelectMany() {
        return getFacade().findAll();
    }

    public List<Calcado> getItemsAvailableSelectOne() {
        return getFacade().findAll();
    }

    @FacesConverter(forClass = Calcado.class)
    public static class CalcadoControllerConverter implements Converter {

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            CalcadoController controller = (CalcadoController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "calcadoController");
            return controller.getCalcado(getKey(value));
        }

        java.lang.Integer getKey(String value) {
            java.lang.Integer key;
            key = Integer.valueOf(value);
            return key;
        }

        String getStringKey(java.lang.Integer value) {
            StringBuilder sb = new StringBuilder();
            sb.append(value);
            return sb.toString();
        }

        @Override
        public String getAsString(FacesContext facesContext, UIComponent component, Object object) {
            if (object == null) {
                return null;
            }
            if (object instanceof Calcado) {
                Calcado o = (Calcado) object;
                return getStringKey(o.getId());
            } else {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), Calcado.class.getName()});
                return null;
            }
        }

    }

}
