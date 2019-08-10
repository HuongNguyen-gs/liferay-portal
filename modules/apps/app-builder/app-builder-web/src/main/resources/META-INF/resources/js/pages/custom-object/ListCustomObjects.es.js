/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

import moment from 'moment';
import React, {useContext, useEffect, useRef, useState} from 'react';
import {withRouter} from 'react-router-dom';
import CustomObjectPopover from './CustomObjectPopover.es';
import {AppContext} from '../../AppContext.es';
import Button from '../../components/button/Button.es';
import ListView from '../../components/list-view/ListView.es';
import {useEscKey} from '../../hooks/index.es';
import {confirmDelete} from '../../utils/client.es';
import isClickOutside from '../../utils/clickOutside.es';
import {addItem} from '../../utils/client.es';

const CUSTOM_OBJECTS = {
	ACTIONS: [
		{
			link: item => `#/custom-object/${item.id}/form-views`,
			name: Liferay.Language.get('form-views')
		},
		{
			link: item => `#/custom-object/${item.id}/table-views`,
			name: Liferay.Language.get('table-views')
		},
		{
			link: item => `#/custom-object/${item.id}/deployments`,
			name: Liferay.Language.get('deployments')
		},
		{
			name: 'divider'
		},
		{
			callback: confirmDelete('/o/data-engine/v1.0/data-definitions/'),
			name: Liferay.Language.get('delete')
		}
	],
	COLUMNS: [
		{
			key: 'name',
			link: item => `/custom-object/${item.id}/form-views`,
			sortable: true,
			value: Liferay.Language.get('name')
		},
		{
			key: 'dateCreated',
			sortable: true,
			value: Liferay.Language.get('create-date')
		},
		{
			asc: false,
			key: 'dateModified',
			sortable: true,
			value: Liferay.Language.get('modified-date')
		}
	],
	FORMATTER: items =>
		items.map(item => ({
			dateCreated: moment(item.dateCreated).fromNow(),
			dateModified: moment(item.dateModified).fromNow(),
			id: item.id,
			name: item.name.en_US
		}))
};

export default withRouter(({history}) => {
	const {siteId} = useContext(AppContext);
	const addButtonRef = useRef();
	const emptyStateButtonRef = useRef();
	const popoverRef = useRef();

	const [alignElement, setAlignElement] = useState(addButtonRef.current);
	const [isPopoverVisible, setPopoverVisible] = useState(false);

	const onClickAddButton = ({currentTarget}) => {
		setAlignElement(currentTarget);

		if (isPopoverVisible && alignElement !== currentTarget) {
			return;
		}

		setPopoverVisible(!isPopoverVisible);
	};

	const onCancel = () => setPopoverVisible(false);

	const onSubmit = ({isAddFormView, name}) => {
		const addURL = `/o/data-engine/v1.0/sites/${siteId}/data-definitions`;

		addItem(addURL, {
			dataDefinitionFields: [],
			name: {
				value: name
			}
		}).then(({id}) => {
			history.push(
				`/custom-object/${id}/form-views/${isAddFormView ? 'add' : ''}`
			);
		});
	};

	useEffect(() => {
		const handler = ({target}) => {
			const isOutside = isClickOutside(
				target,
				addButtonRef.current,
				emptyStateButtonRef.current,
				popoverRef.current
			);

			if (isOutside) {
				setPopoverVisible(false);
			}
		};

		window.addEventListener('click', handler);

		return () => window.removeEventListener('click', handler);
	}, [addButtonRef, emptyStateButtonRef, popoverRef]);

	useEscKey(() => {
		if (isPopoverVisible) {
			setPopoverVisible(false);
		}
	}, [isPopoverVisible, setPopoverVisible]);

	return (
		<>
			<ListView
				actions={CUSTOM_OBJECTS.ACTIONS}
				addButton={() => (
					<div ref={addButtonRef}>
						<Button
							className="nav-btn nav-btn-monospaced navbar-breakpoint-down-d-none"
							onClick={onClickAddButton}
							symbol="plus"
							tooltip={Liferay.Language.get('new-custom-object')}
						/>
					</div>
				)}
				columns={CUSTOM_OBJECTS.COLUMNS}
				emptyState={{
					button: () => (
						<Button
							displayType="secondary"
							onClick={onClickAddButton}
							ref={emptyStateButtonRef}
						>
							{Liferay.Language.get('new-custom-object')}
						</Button>
					),
					description: Liferay.Language.get(
						'custom-objects-define-the-types-of-data-your-business-application-needs'
					),
					title: Liferay.Language.get(
						'there-are-no-custom-objects-yet'
					)
				}}
				endpoint={`/o/data-engine/v1.0/sites/${siteId}/data-definitions`}
				formatter={CUSTOM_OBJECTS.FORMATTER}
			/>

			<CustomObjectPopover
				alignElement={alignElement}
				onCancel={onCancel}
				onSubmit={onSubmit}
				ref={popoverRef}
				visible={isPopoverVisible}
			/>
		</>
	);
});
