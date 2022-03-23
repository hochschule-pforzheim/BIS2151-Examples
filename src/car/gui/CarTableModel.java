package car.gui;

import car.data.Car;
import java.util.List;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;

/**
 *
 * @author Prof. Werner Burkard
 */
public class CarTableModel extends javax.swing.table.AbstractTableModel
{

    private final List<Car> carList;

    private final String[] columnNames = new String[]
    {
        "Id", "Description", "Price", "Available"
    };
    private final Class[] columnClass = new Class[]
    {
        Integer.class, String.class, Double.class, Boolean.class
    };

    public CarTableModel()
    {
        this.carList = Car.getCarList();
    }

    @Override
    public String getColumnName(int column)
    {
        return columnNames[column];
    }

    @Override
    public Class<?> getColumnClass(int columnIndex)
    {
        return columnClass[columnIndex];
    }

    @Override
    public int getColumnCount()
    {
        return columnNames.length;
    }

    @Override
    public int getRowCount()
    {
        return carList.size();
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex)
    {
        Car row = carList.get(rowIndex);
        if (0 == columnIndex)
        {
            return row.getCarID();
        }
        else if (1 == columnIndex)
        {
            return row.getCarDescription();
        }
        else if (2 == columnIndex)
        {
            return row.getCarPrice();
        }
        else if (3 == columnIndex)
        {
            return row.isAvailable();
        }
        return null;
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex)
    {
        Car carInThatRow = carList.get(rowIndex);
        switch (columnIndex)
        {
            case 0:
                carInThatRow.setCarID((Integer) aValue);
                break;
            case 1:
                carInThatRow.setCarDescription((String) aValue);
                break;
            case 2:
                carInThatRow.setCarPrice((Double) aValue);
                break;
            case 3:
                carInThatRow.setAvailable((Boolean) aValue);
                break;
            default:
                break;
        }
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex)
    {
        if (columnIndex == 0)
        {
            return false;
        }
        else
        {
            return true;
        }
    }

    void addRow(Car newCar)
    {
        // Insert the new car into the arraylist
        carList.add(newCar);
        Car.incrementCarListNextID();
        // Create an event that the model has changed because there was data inserted:
        TableModelEvent addedRowEvent = new TableModelEvent(this, TableModelEvent.ALL_COLUMNS, TableModelEvent.INSERT);
        // get an array of all the listeners that the actual CarTableModel object has:
        TableModelListener[] allMyListeners = (TableModelListener[]) (this.getListeners(TableModelListener.class));
        // Inform all of them that the data in the model has changed by sending the event to them
        for (TableModelListener aListener : allMyListeners)
        {
            aListener.tableChanged(addedRowEvent);
        }
    }

    void deleteRow(int selectedLine)
    {
        // Delete the car in the arraylist that is in the selectedLine
        carList.remove(selectedLine);
        // Create an event that the model has changed because there was data deleted:
        TableModelEvent deletedRowEvent = new TableModelEvent(this, TableModelEvent.ALL_COLUMNS, TableModelEvent.DELETE);
        // get an array of all the listeners that the actual CarTableModel object has:
        TableModelListener[] allMyListeners = (TableModelListener[]) (this.getListeners(TableModelListener.class));
        // Inform all of them that the data in the model has changed by sending the event to them
        for (TableModelListener aListener : allMyListeners)
        {
            aListener.tableChanged(deletedRowEvent);
        }
    }
}
