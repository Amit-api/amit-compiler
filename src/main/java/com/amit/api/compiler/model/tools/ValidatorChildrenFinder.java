package com.amit.api.compiler.model.tools;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.amit.api.compiler.model.PrimitiveTypeNames;
import com.amit.api.compiler.model.TypeComposite;
import com.amit.api.compiler.model.TypeCompositeMember;
import com.amit.api.compiler.model.TypedItem;
import com.amit.api.compiler.model.Type;

public class ValidatorChildrenFinder {
	@SuppressWarnings("serial")
	private static final Set<String> primitiveTypes = new HashSet<String>() {
		{
			addAll(Arrays.asList(PrimitiveTypeNames.ALL));
		}
	};

	private final Set<String> typesToValidate = new HashSet<String>();

	public ValidatorChildrenFinder(List<? extends TypedItem> items,
			Set<String> initialTypesWithValidation) {

		Set<String> typesWithValidation = new HashSet<String>(
				initialTypesWithValidation);
		Set<String> excludeTypes = new HashSet<String>();

		for (TypedItem item : items) {
			if (addTypesToValidate(typesToValidate, item, typesWithValidation,
					excludeTypes)) {
				typesToValidate.add(item.getTypeName());
				typesWithValidation.add(item.getTypeName());
			}
		}
	}

	public Set<String> result() {
		return typesToValidate;
	}

	private static boolean addTypesToValidate(Set<String> typesToValidate,
			TypedItem item, Set<String> typesWithValidation,
			Set<String> excludeTypes) {
		String typeName = item.getTypeName();

		if (primitiveTypes.contains(typeName)
				|| excludeTypes.contains(typeName)) {
			return false;
		}

		if (typesWithValidation.contains(typeName)) {
			return true;
		}

		Type type = item.getProject().getType(typeName);
		if (!type.isComposite()) {
			return false;
		}

		excludeTypes.add(typeName);
		boolean result = false;

		TypeComposite typeComposite = (TypeComposite) type;
		for (TypeCompositeMember member : typeComposite.getAllMembers()) {
			if (addTypesToValidate(typesToValidate, member,
					typesWithValidation, excludeTypes)) {
				result = true;
				typesToValidate.add(member.getTypeName());
				typesWithValidation.add(member.getTypeName());
			}
		}

		excludeTypes.remove(typeName);

		return result;
	}

}
