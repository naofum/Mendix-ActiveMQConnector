// This file was generated by Mendix Modeler.
//
// WARNING: Only the following code will be retained when actions are regenerated:
// - the import list
// - the code between BEGIN USER CODE and END USER CODE
// - the code between BEGIN EXTRA CODE and END EXTRA CODE
// Other code you write will be lost the next time you deploy the project.
// Special characters, e.g., é, ö, à, etc. are supported in comments.

package activemqconnector.actions;

import java.util.Set;
import java.util.Map.Entry;
import com.mendix.core.Core;
import com.mendix.systemwideinterfaces.MendixRuntimeException;
import com.mendix.systemwideinterfaces.core.IContext;
import com.mendix.systemwideinterfaces.core.IDataType;
import com.mendix.webui.CustomJavaAction;
import com.mendix.systemwideinterfaces.core.IMendixObject;

/**
 * Validates if the microflow configured through Model Reflection is still correct, by querying the Mendix Model (as opposed to the database).
 * 
 *  - Microflow must exist
 *  - Microflow must have a single input parameter
 *  - Input parameter must be of type String
 */
public class ValidateMicroflow extends CustomJavaAction<java.lang.Boolean>
{
	private IMendixObject __microflow;
	private mxmodelreflection.proxies.Microflows microflow;

	public ValidateMicroflow(IContext context, IMendixObject microflow)
	{
		super(context);
		this.__microflow = microflow;
	}

	@Override
	public java.lang.Boolean executeAction() throws Exception
	{
		this.microflow = __microflow == null ? null : mxmodelreflection.proxies.Microflows.initialize(getContext(), __microflow);

		// BEGIN USER CODE
		if (microflow == null) throw new IllegalArgumentException("Input object is empty");
		String microflowName = microflow.getCompleteName();
		Set<String> microflows = Core.getMicroflowNames();
		if (!microflows.contains(microflowName)) throw new MendixRuntimeException("Microflow does not exists: " + microflowName);
		Set<Entry<String, IDataType>> parameters = Core.getInputParameters(microflowName).entrySet();
		if (parameters.size() != 1) throw new MendixRuntimeException("Microflow does not have exactly one parameter: " + microflowName);
		for(Entry<String,IDataType> parameter : parameters) {
			if (parameter.getValue().getType() != IDataType.DataTypeEnum.String) throw new MendixRuntimeException("Microflow does not have the correct input type: " + microflowName);
		}
		return true;
		// END USER CODE
	}

	/**
	 * Returns a string representation of this action
	 */
	@Override
	public java.lang.String toString()
	{
		return "ValidateMicroflow";
	}

	// BEGIN EXTRA CODE
	// END EXTRA CODE
}
